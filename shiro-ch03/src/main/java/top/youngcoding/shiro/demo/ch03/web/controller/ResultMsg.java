package top.youngcoding.shiro.demo.ch03.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liy
 * @date 2018/4/25
 */
@Slf4j
public class ResultMsg {

    public static String ok() {
        return ok(null);
    }

    public static String ok(HttpServletRequest request) {
        String msg = "";
        if (request != null)
            msg += "请求路径："+request.getServletPath() + "<p>";
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        msg += "成功调用方法：" + element.getClassName() + "." + element.getMethodName() + "(..)";
        log.info(msg);
        return msg;
    }
    public static void user(Model model){
        model.addAttribute("username", SecurityUtils.getSubject().getPrincipal());
    }
}