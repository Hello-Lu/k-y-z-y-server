package com.server.UserControl.controller;

import com.server.UserControl.service.ClientUserService;
import com.server.api.clientControl.clientUserApi;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Client_user;
import com.server.model.UserLogin;
import com.server.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ClientUserController implements clientUserApi {
    @Autowired
    ClientUserService clientUserService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Value("${gmall.jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${gmall.jwt.tokenHead}")
    private String tokenHead;
    @Override
    /**
     * 查看客户端注册的用户信息
     */
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findclientuserList(@PathVariable("page") int page, @PathVariable("size")int size) {

        return clientUserService.findclientuserList(page,size);
    }

    /**
     * 在后台批量导入用户
     * @param client_users
     * @return
     */
    @Override
    @PostMapping("/list/addUser")
    public ResponseResult addbatchUser(@RequestBody List<Client_user> client_users) {
        return clientUserService.addbatchUser(client_users);
    }
    /**
    *修改状态 启用|禁用
     */
    @Override
    @PostMapping("/Status")
    public ResponseResult EnableAndDisableuser(@RequestParam("id") String id,@RequestParam("Status") String Status) {
        return clientUserService.EnableAndDisableuser(id,Status);
    }

    @Override
    @PostMapping("/ExportUser")
    public ResponseResult BatchExportUser(@RequestBody List<String> id) {
        return clientUserService.BathExportUser(id);
    }

    @Override
    @PostMapping("/Rest")
    public ResponseResult ResetPassword(@RequestParam("id") String id, @RequestParam("password") String password) {
        return clientUserService.ResetPassword(id,password);
    }

    @PostMapping("/login")
    public Map<String, String> login(Client_user user, BindingResult result){
        Client_user userLogin = clientUserService.login(user);
        String token = jwtTokenUtil.generateToken(userLogin);
        if (token == null){
            return null;
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return tokenMap;
    }

    @GetMapping("/info")
    public Map getUserInfo(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUserNameFromToken(token);
        Client_user user = clientUserService.getUser(username);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("phone",user.getPhone());
        map.put("name",user.getName());

        return map;
    }
}
