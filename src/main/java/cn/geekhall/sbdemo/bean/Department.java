package cn.geekhall.sbdemo.bean;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.sql.Date;

/**
 * Department
 *
 * @author yiny
 */
@Data
public class Department {
    private Long id;
    private String name;
    private Long parentId;
    private String depPath;
    private Boolean enabled;
    private Boolean isParent;
    private Date datetime;
    private String remark;
}
