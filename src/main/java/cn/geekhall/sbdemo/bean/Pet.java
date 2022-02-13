package cn.geekhall.sbdemo.bean;

import lombok.*;

/**
 * Pet
 *
 * @author yiny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pet {
    private String name;
    private Double weight;
}
