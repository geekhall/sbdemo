package cn.geekhall.sbdemo.service.impl;

import cn.geekhall.sbdemo.bean.Role;
import cn.geekhall.sbdemo.mapper.RoleMapper;
import cn.geekhall.sbdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleService
 *
 * @author yiny
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    public Role getById(Long id){
        return roleMapper.getById(id);
    }

    public void saveRole(Role role) {
        roleMapper.insert(role);
    }
}
