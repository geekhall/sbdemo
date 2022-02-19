package cn.geekhall.profiledemo.controller;

import cn.geekhall.profiledemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
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


    @Autowired
    private Person person;

    @Value("${file.encoding}")
    private String msg;

    @Value("${os.name}") // 取不到会崩溃
    private String os;

    @GetMapping("/hello")
    public Person hello(){
        return person;
    }

    @GetMapping("/msg")
    public String msg(){
        return msg + os;
    }
}
