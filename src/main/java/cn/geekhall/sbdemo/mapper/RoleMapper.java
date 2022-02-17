package cn.geekhall.sbdemo.mapper;

import cn.geekhall.sbdemo.bean.Role;
import org.apache.ibatis.annotations.Mapper;
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

    void insert(Role role);
}
