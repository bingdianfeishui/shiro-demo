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
@RequestMapping("/cart")
@RequiresPermissions("cart")
public class CartController {
    @GetMapping("add")
    @RequiresPermissions("cart:add")
    public String add(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("remove")
    public String remove(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("clear")
    public String clear(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }

    @GetMapping("list")
    public String list(HttpServletRequest request, Model model) {
        model.addAttribute("msg", ResultMsg.ok(request));
        return "index";
    }
}
