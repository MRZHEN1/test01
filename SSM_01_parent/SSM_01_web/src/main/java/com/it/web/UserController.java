package com.it.web;

import com.it.bean.UserBean;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping(path = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        List<UserBean> users = userService.findAll();
        model.addAttribute("users",users);
        return "list" ;
    }

    /**
     * 用户注册的功能
     * @param
     * @return
     */
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String add(UserBean user){
        userService.add(user);
        System.out.println("注册方法执行....");
        //重定向到查询所有功能
        return "redirect:/user/findAll";
    }

}
