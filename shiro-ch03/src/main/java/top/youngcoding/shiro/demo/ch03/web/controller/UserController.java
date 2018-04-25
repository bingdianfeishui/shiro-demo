package top.youngcoding.shiro.demo.ch03.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liy
 * @date 2018/4/25
 */
@Controller
@RequestMapping("/member")
@RequiresPermissions("member")
public class UserController {

    @GetMapping("changeOnline")
    public String changeOnline(HttpServletRequest request, Model model){
        model.addAttribute("msg",ResultMsg.ok(request));
        return "index";
    }
    @GetMapping("forbid")
    public String forbid(HttpServletRequest request, Model model){
        model.addAttribute("msg",ResultMsg.ok(request));
        return "index";
    }
    @GetMapping("delete")
    public String delete(HttpServletRequest request, Model model){
        model.addAttribute("msg",ResultMsg.ok(request));
        return "index";
    }
    @GetMapping("list")
    public String list(HttpServletRequest request, Model model){
        model.addAttribute("msg",ResultMsg.ok(request));
        return "index";
    }
    @GetMapping("clearRole")
    public String clearRole(HttpServletRequest request, Model model){
        model.addAttribute("msg",ResultMsg.ok(request));
        return "index";
    }
}
