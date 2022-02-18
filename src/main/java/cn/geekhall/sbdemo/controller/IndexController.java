package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.bean.Department;
import cn.geekhall.sbdemo.bean.Role;
import cn.geekhall.sbdemo.service.impl.DepartmentServiceImpl;
import cn.geekhall.sbdemo.service.impl.RoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * IndexController
 *
 * @author yiny
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    RoleServiceImpl roleServiceImpl;

    @ResponseBody
    @GetMapping("/role")
    public Role getRoleById(@RequestParam("id") Long id){
        return roleServiceImpl.getById(id);
    }
    @ResponseBody
    @GetMapping("/de partment")
    public Department getDepartmentById(@RequestParam("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @ResponseBody
    @PostMapping("/role")
    public Role saveRole(Role role) {
        roleServiceImpl.saveRole(role);
        return role;
    }
//    @RequestBody
//    @GetMapping("/sql")
//    public String queryFromDb(){
//
//    }
}
