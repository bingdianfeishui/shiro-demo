package top.youngcoding.shiro.demo.ch02.web.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author liy
 * @date 2018/4/20
 */
public class ImgCaptchaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("========" + this.getClass().getName());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
