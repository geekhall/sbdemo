package cn.geekhall.profiledemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author yiny
 */
@RestController
public class HelloController {

    @Value("${person.name: 李四}")
    private String name;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello" + name;
    }
}
