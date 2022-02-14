package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.bean.Car;
import cn.geekhall.sbdemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET - User";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST - User";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser(){
        return "PUT - User";
    }

    /**
     * @RequestMapping(value = "/user", method = RequestMethod.DELETE)
     * 与
     * @DeleteMapping("/user") 作用相同
     * @return
     */
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE - User";
    }
}
