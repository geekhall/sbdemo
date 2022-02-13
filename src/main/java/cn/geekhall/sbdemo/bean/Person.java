package cn.geekhall.sbdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Person
 *
 * @author yiny
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String username;
    private String boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animals;
    private Map<String, Object> scores;
    private Set<Double> salaries;
    private Map<String, List<Pet>> allPets;
}
