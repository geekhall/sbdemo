package cn.geekhall.sbdemo.controller;

import cn.geekhall.sbdemo.bean.User;
import cn.geekhall.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String basic_table(@RequestParam("a") int a){
        int i = 10/0;
        return "table/basic_table";
    }

    @ResponseBody
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);

        return "table/dynamic_table";
//        return use rs;
    }
}
