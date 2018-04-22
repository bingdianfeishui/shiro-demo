package top.youngcoding.shiro02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author liy
 * @date 2018/4/20
 */

@Configuration
@EnableWebMvc
//@Import(ShiroConfig.class)
@ComponentScan("top.youngcoding.shiro02")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp").cache(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**","/css/**","/image/**").addResourceLocations("/js/","/css/","/image/").setCachePeriod(30*24*60*60);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
}
