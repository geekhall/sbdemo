package cn.geekhall.geekhallbootdemo.controller;

import cn.geekhall.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author yiny
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        String msg = helloService.sayHello("张三");
        return msg;
    }
}
