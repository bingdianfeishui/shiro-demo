package top.youngcoding.shiro.demo.ch03.web.controller;

import org.aopalliance.intercept.MethodInterceptor;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liy
 * @date 2018/4/25
 */
//@Aspect
//@Configuration
public class UsernameInceptor{

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointcut(){
    }

    @Pointcut("execution(* top.youngcoding.shiro.demo.ch03..LoginController.*(..))")
    public void pointcut2(){

    }

    @Before("pointcut2()")
    public void before2(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        Model model = (Model) args[1];
        System.out.println(ResultMsg.ok(request));
        System.out.println("======================");
        model.addAttribute("username", SecurityUtils.getSubject().getPrincipal());
    }
}
