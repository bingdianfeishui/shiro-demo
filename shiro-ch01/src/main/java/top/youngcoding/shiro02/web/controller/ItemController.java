package top.youngcoding.shiro02.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liy
 * @date 2018/4/17
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @RequestMapping("add")
    public String add() {
        return "item/add";
    }

    @RequestMapping("delete")
    public String delete() {
        return "item/delete";
    }

    @RequestMapping("update")
    public String update() {
        return "item/update";
    }

    @RequestMapping("list")
    public String list() {
        return "item/list";
    }
}
