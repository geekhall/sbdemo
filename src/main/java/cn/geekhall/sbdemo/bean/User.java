package cn.geekhall.sbdemo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User
 *
 * @author yiny
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tbl")
public class User {

    // MybatisPlus要求所有属性都应该在数据库中，若不存在需要使用@TableField注解标注。
    @TableField(exist = false)  // 当前属性在数据库表中不存在。
    private String userName;
    @TableField(exist = false)
    private String password;

    // 以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
