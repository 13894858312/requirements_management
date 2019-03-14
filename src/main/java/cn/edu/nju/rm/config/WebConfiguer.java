package cn.edu.nju.rm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangxue
 * Created by wangxue on 2019/3/12.
 */
@SpringBootConfiguration
public class WebConfiguer extends WebMvcConfigurerAdapter {

    @Autowired
    Interceptor interceptor;

    /**
     * 配置静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login**", "/register**") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/home", "/error")
                .excludePathPatterns("/login/**", "/register/**")
                .excludePathPatterns("/post/project**", "/post/searchProject**", "/post/searchResult**", "/post/projectList**");
        super.addInterceptors(registry);
    }
}
