package com.zfy.action;

import com.zfy.entity.Admin;
import com.zfy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sun.plugin2.message.Message;

import javax.servlet.http.HttpSession;

//创建action 对象
@Controller
//相当于namespace
@RequestMapping("/admin")
@SessionAttributes(value = {"message"})
public class AdminAction {
    // service 自动注入
    @Autowired
    private AdminService adminService;

    //相当于action 的 name属性
    @RequestMapping("/register")
    // 用对象收参数
    public String register(Admin admin,HttpSession session) throws Exception {
        //调用视图解析器

        adminService.register(admin);
        session.setAttribute("admin",admin);
        session.setAttribute("login","y");
        //配置视图解析器
        return "redirect:/Dept/showAll.go";
    }

    //登录
    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpSession session) {
        Admin a = adminService.login(admin);
        session.setAttribute("admin",a);
        if (a != null) {
            session.setAttribute("login", "y");
            return "redirect:/Dept/showAll.go";
        } else {
            return "login";
        }
    }
}
