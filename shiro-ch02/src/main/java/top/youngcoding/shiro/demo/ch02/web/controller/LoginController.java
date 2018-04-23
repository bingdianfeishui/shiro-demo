package top.youngcoding.shiro.demo.ch02.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.youngcoding.shiro.demo.ch02.entity.User;

/**
 * @author liy
 * @date 2018/4/20
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(User user, Model model) {
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        try {
            SecurityUtils.getSubject().login(upt);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:login";
        }
        model.addAttribute("username", user.getUsername());
        return "index";
    }

    @GetMapping("/order/{op}")
    @ResponseBody
    public String orderOp(@PathVariable String op){
        return "Order OP:" + op;
    }
}
