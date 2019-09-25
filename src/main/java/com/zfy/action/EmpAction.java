package com.zfy.action;


import com.zfy.entity.Emp;
import com.zfy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpAction {
    @Autowired
    private EmpService empService;

    @RequestMapping("/showAll")
    public String showAll(Integer did, Model model) throws Exception {
        List<Emp> emps = empService.showAll(did);
        model.addAttribute("emps", emps);
        return "emplist";
    }

    @RequestMapping("/addemp")
    public String addemp(Emp emp, MultipartFile upload, HttpSession session) throws Exception {
        //获取upload(目标文件夹)的路径

        ServletContext servletContext = session.getServletContext();
        //获取upload对应的路径
        String realPath = servletContext.getRealPath("/shangchuan");
        //把上传的文件 输出到/upload文件夹中 文件名字
        // 在upload文件夹中创建了与上传文件同名的文件 空文件
        File f;
        if (upload != null) {
            f = new File(realPath + "//" + upload.getOriginalFilename());
            upload.transferTo(f);
        }
        //把上传的文件内容转换到空文件中
        emp.setHeadlike(upload.getOriginalFilename());
        empService.addemp(emp);
        return "redirect:/Dept/showAll.go";
    }

    @RequestMapping("/ToUpdate")
    public String toUpdate(Integer id, Model model) throws Exception {
        Emp emp = empService.selectbyid(id);
        model.addAttribute("emp", emp);
        return "updateEmp";
    }

    @RequestMapping("/update")
    public String update(Emp emp, MultipartFile upload, HttpSession session) throws Exception {
        if (upload == null) {
            empService.update(emp);
        } else {
            ServletContext servletContext = session.getServletContext();
            //获取upload对应的路径
            String realPath = servletContext.getRealPath("/shangchuan");
            //把上传的文件 输出到/upload文件夹中 文件名字
            // 在upload文件夹中创建了与上传文件同名的文件 空文件
            File f = new File(realPath + "//" + upload.getOriginalFilename());
            upload.transferTo(f);
            //把上传的文件内容转换到空文件中
            emp.setHeadlike(upload.getOriginalFilename());
            empService.update(emp);
        }
        return "redirect:/Dept/showAll.go";
    }

    @RequestMapping("/delete")
    public String delete(String id) throws Exception {
        empService.delete(id);
        return "redirect:/Dept/showAll.go";
    }
}
