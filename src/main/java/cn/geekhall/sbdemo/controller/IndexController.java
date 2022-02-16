package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.bean.Department;
import cn.geekhall.sbdemo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    DepartmentService departmentService;

    @ResponseBody
    @GetMapping("/department")
    public Department getDepartmentById(@RequestParam("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

//    @RequestBody
//    @GetMapping("/sql")
//    public String queryFromDb(){
//
//    }
}
