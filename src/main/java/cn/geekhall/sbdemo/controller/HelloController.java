package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.bean.Car;
import cn.geekhall.sbdemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author yiny
 */
@RestController
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    Person person;

    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot 2======!" + " 你好";
    }

    @RequestMapping("/person")
    public Person getPerson(){
        return person;
    }

}
