package cn.geekhall.sbdemo.mapper;

import cn.geekhall.sbdemo.bean.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * DepartmentMapper
 *
 * @author yiny
 */
@Mapper
public interface DepartmentMapper {
    Department getDept(Long id);
}
