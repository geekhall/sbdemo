package cn.geekhall.sbdemo.service.impl;

import cn.geekhall.sbdemo.bean.Department;
import cn.geekhall.sbdemo.mapper.DepartmentMapper;
import cn.geekhall.sbdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DepartmentService
 *
 * @author yiny
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDepartmentById(Long id) {
        return departmentMapper.getDept(id);
    }
}
