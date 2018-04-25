package top.youngcoding.shiro.demo.ch03.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liy
 * @date 2018/4/24
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.getAttribute("user");
        //TODO
        return "index";
    }

    @GetMapping("/mainboard")
    public String mainboard() {
        return "mainboard";
    }

    @GetMapping("/admin/{str}")
    public String admin(@PathVariable("str")String str){
        System.out.println(str);
        return "index";
    }
}
