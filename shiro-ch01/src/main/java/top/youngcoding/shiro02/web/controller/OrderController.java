package top.youngcoding.shiro02.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liy
 * @date 2018/4/17
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("add")
    public String add() {
        return "order/add";
    }

    @RequestMapping("delete")
    public String delete() {
        return "order/delete";
    }

    @RequestMapping("update")
    public String update() {
        return "order/update";
    }

    @RequestMapping("submit")
    public String submit() {
        return "order/submit";
    }
}
