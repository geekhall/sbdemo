package cn.geekhall.sbdemo.config;

import cn.geekhall.sbdemo.interceptor.LoginInterceptor;
import cn.geekhall.sbdemo.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * AdminWebConfig
 *
 * @author yiny
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * 面试题：Filter、Interceptor 几乎拥有相同的功能，有什么区别？
     * 1. Filter是Servlet定义的原生组件，好处：脱离Spring也能使用。
     * 2. Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能。
     */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     // 所有请求都被拦截，包括静态资源。
                // 以下请求被放行
//                .excludePathPatterns("/","/login","/css/**", "/fonts/**","/images/**","/js/**","/aa/**","/sql","/city","/role");
                .excludePathPatterns("/","/login","/css/**", "/fonts/**","/images/**","/js/**","/aa/**");

        // 注意不能使用以下写法，不应该使用自己new的对象，而应该从容器中拿，否则对象中的Autowired属性不好用。
//        registry.addInterceptor(new RedisUrlCountInterceptor());

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**", "/fonts/**","/images/**","/js/**","/aa/**");
    }


}
