package cn.geekhall.geekhallbootdemo.config;

import cn.geekhall.starter.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfig
 *
 * @author yiny
 */
@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
