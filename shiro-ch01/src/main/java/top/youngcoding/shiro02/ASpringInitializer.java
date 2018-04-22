package top.youngcoding.shiro02;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author liy
 * @date 2018/4/18
 */
public class ASpringInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("================DispatcherServlet===================");
        ServletRegistration.Dynamic servlet = servletContext.addServlet("springmvc", DispatcherServlet.class);
        servlet.setInitParameter("contextConfigLocation","classpath:shiro02.xml,classpath:spring-mvc.xml");
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        System.out.println("=============");

    }
}
