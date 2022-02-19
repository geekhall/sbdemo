package cn.geekhall.sbdemo.service.impl;

import cn.geekhall.sbdemo.bean.Role;
import cn.geekhall.sbdemo.mapper.RoleMapper;
import cn.geekhall.sbdemo.service.RoleService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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

    Counter counter;

    public RoleServiceImpl(MeterRegistry meterRegistry) {
        // http://localhost:8888/actuator/metrics/roleService.saveRole.count
        counter = meterRegistry.counter("roleService.saveRole.count");
    }

    public Role getById(Long id){
        return roleMapper.getById(id);
    }

    public void saveRole(Role role) {
        counter.increment();
        roleMapper.insert(role);
    }
}
