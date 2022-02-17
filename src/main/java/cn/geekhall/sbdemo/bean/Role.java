package cn.geekhall.sbdemo.bean;

import lombok.Data;

import java.sql.Date;

/**
 * Role
 *
 * @author yiny
 */
@Data
public class Role {
    private Long id;
    private String code;
    private String name;
    private Date gmtCreate;
    private Boolean enabled;
    private String remark;
}
