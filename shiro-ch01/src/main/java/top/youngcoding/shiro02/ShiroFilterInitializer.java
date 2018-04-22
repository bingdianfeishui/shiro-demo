package top.youngcoding.shiro02;

import org.springframework.web.WebApplicationInitializer;
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
public class ShiroFilterInitializer implements WebApplicationInitializer {
    private static boolean isEnableShiro = false;
    static{
        System.out.println("+++++++++enable shiro02++++++++++");
        isEnableShiro = true;
    }
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("================ShiroFilterInitializer===================");
        if(isEnableShiro){
            FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("shiroFilter", new DelegatingFilterProxy());
            shiroFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
        }
        System.out.println("=============");
    }
}
