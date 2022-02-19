package cn.geekhall.profiledemo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Person
 *
 * @author yiny
 */

@Data
@Component
@ConfigurationProperties("person")
public class Person {
    private String name;
    private Integer age;
}
