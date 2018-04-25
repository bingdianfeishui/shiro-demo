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
@RequestMapping("/role")
@RequiresPermissions("role")
public class RoleController {
    @GetMapping("add")
    public String add(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("delete")
    public String delete(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("index")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("allocation")
    public String allocation(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("changePermission")
    public String changePermission(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("clearPermission")
    public String clearPermission(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }
}
