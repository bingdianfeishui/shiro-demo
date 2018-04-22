package top.youngcoding.shiro02;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author liy
 * @date 2018/4/18
 */
public class CharFilterInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("================CharacterEncodingFilter===================");
        FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("charsetFilter", new CharacterEncodingFilter("UTF-8"));
        shiroFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
        System.out.println("=============");
    }
}
