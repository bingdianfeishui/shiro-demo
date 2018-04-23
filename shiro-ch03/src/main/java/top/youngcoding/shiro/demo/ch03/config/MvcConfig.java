package top.youngcoding.shiro.demo.ch03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author liy
 * @date 2018/4/23
 */
@Configuration
@EnableWebMvc
@ComponentScan("top.youngcoding.shiro.demo.ch03.web")
//@Import({ShiroConfig.class})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/templates/").suffix(".jsp").cache(false);
        super.configureViewResolvers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**", "/css/**", "/image/**").addResourceLocations("/js/", "/css/", "/image/").setCachePeriod(30 * 24 * 60 * 60);
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("mainbord");
        super.addViewControllers(registry);
    }
}
