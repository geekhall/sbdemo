package cn.geekhall.sbdemo.service;

import cn.geekhall.sbdemo.bean.Role;

/**
 * RoleService
 *
 * @author yiny
 */
public interface RoleService {
    Role getById(Long id);
    void saveRole(Role role);
}
