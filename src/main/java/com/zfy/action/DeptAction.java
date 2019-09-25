package com.zfy.action;

import com.alibaba.fastjson.JSON;
import com.zfy.entity.Dept;
import com.zfy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Dept")
public class DeptAction {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/showAll")
    public String showAll(Model model) throws  Exception{
        List<Dept> depts = deptService.showAll();
        model.addAttribute("depts",depts);
        return "departments";
    }
    @RequestMapping("/adddept")
    public String adddept(Dept dept) throws Exception{
        deptService.adddept(dept);
        return "redirect:/Dept/showAll.go";
    }
    @RequestMapping("/selectbyid")
    public String selectbyid(Integer id,Model model) throws Exception{
        Dept dept1 = deptService.selectbyid(id);
        model.addAttribute("dept1",dept1);
        return "updateDepartment";
    }
    @RequestMapping("/update")
    public String update(Dept dept) throws  Exception{
        deptService.update(dept);
        return "redirect:/Dept/showAll.go";
    }
    @RequestMapping("/selectDep")
    public String selectDep(HttpServletResponse response) throws Exception{
        List<Dept> depts=deptService.selectDepname();
        String s = JSON.toJSONString(depts);
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
