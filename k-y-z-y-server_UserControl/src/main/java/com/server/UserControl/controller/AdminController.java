package com.server.UserControl.controller;

import com.server.UserControl.service.AdminService;
import com.server.api.UserControl.UserControl;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.request.usercontrol.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController implements UserControl {

    @Autowired
    AdminService adminService;

    /**
    添加用户
     */
    @Override
    @PostMapping("/add")
    public ResponseResult addUser(user user) {
        return adminService.add(user);
    }

    @Override
    @PostMapping("/useUser")
    public ResponseResult useUser(@RequestParam("account") String account) {
        return adminService.userUser(account);
    }

    @Override
    @PostMapping("/stopUser")
    public ResponseResult stopUser(@RequestParam("account") String account) {
        return adminService.stopUser(account);
    }

    @Override
    @PostMapping("/limitsUser")
    public ResponseResult limitsUser(@RequestParam("account") String account,@RequestParam("limits")Integer limits ) {
        return adminService.limitsUser(account,limits);
    }

    @GetMapping("/list")
    public QueryResponseResult SelectUser(@RequestParam(value = "page",defaultValue = "1") int page){
       return adminService.getUserList(page);
    }
    @Override
    @PostMapping("/login")
        public QueryResponseResult login(user user) {
        return adminService.login(user);
    }


}
