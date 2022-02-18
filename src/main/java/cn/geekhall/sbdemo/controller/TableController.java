package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TableController
 *
 * @author yiny
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(int a){
        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
//        userService.getAll();
        return "table/dynamic_table";
    }
}
