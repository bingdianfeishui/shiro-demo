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
@RequestMapping("/order")
@RequiresPermissions("order")
public class OrderController {
    @GetMapping("create")
    public String create(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("delete")
    public String delete(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("submit")
    public String submit(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("list")
    public String list(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("detail")
    public String detail(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }
}
