package top.youngcoding.shiro.demo.ch01.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.youngcoding.shiro.demo.ch01.entity.User;

/**
 * @author liy
 * @date 2018/4/17
 */
@Controller
public class LoginController {
    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String unauth() {
        return "403";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @PostMapping("/login")
    public String doLogin(User user){
        user.setSalt("salt");
        System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword().toCharArray(), user.getSalt());
        token.setRememberMe(true);

        try {
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException ex) {
            ex.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException ex) {
            ex.printStackTrace();
            return "login";
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            return "login";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "login";
        }
        return "success";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
