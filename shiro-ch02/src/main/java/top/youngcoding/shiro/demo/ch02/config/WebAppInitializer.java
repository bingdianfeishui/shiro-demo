package top.youngcoding.shiro.demo.ch02.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import top.youngcoding.shiro.demo.ch02.web.controller.ImgCaptchaFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author liy
 * @date 2018/4/20
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        super.onStartup(servletContext);
        servletContext.addFilter("imgCaptchaFilter", ImgCaptchaFilter.class)
                .addMappingForUrlPatterns(null, false, "/captcha*");
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
        // characterEncodingFilter.setEncoding("UTF-8");
        DelegatingFilterProxy shiroFilter = new DelegatingFilterProxy("shiroFilter");
        return new Filter[]{characterEncodingFilter, shiroFilter};
    }
}
