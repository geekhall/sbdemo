package cn.geekhall.sbdemo.mapper;

import cn.geekhall.sbdemo.bean.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RoleMapper
 *
 * @author yiny
 */
@Mapper
public interface RoleMapper {

    @Select("select * from t_role where id=#{id}")
    Role getById(Long id);


    // 使用配置文件方式
//    void insert(Role role);

    // 使用标签
    @Insert("insert into t_role (`code`, `name`, `gmt_create`, `enabled`, `remark`) values (#{code}, #{name}, #{gmtCreate}, #{enabled}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Role role);
}
