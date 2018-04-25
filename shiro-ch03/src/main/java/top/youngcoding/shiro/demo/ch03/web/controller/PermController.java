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
@RequestMapping("/perm")
@RequiresPermissions("permission")
public class PermController {
    @GetMapping("index")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

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

    @GetMapping("allocation")
    public String allocation(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }
}
