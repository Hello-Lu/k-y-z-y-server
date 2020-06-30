package com.server.UserControl.service;

import com.server.UserControl.dao.ClientUserRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Client_user;
import com.server.model.User;
import com.server.model.UserLogin;
import com.server.model.request.usercontrol.user;
import com.server.utils.JwtTokenUtil;
import com.server.utils.Oauth2Util;
import org.aspectj.weaver.IUnwovenClassFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ClientUserService {

    @Autowired
    ClientUserRepository clientUserRepository;


    public QueryResponseResult findclientuserList(int page, int size) {
        //分页参数
        if (page<=0){
            page=1;
        }
        page=page-1;
        if (size<=0){
            size=10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Client_user> all = clientUserRepository.findAll(pageable);

        QueryResult queryResult=new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    public ResponseResult addbatchUser(List<Client_user> client_users) {

        if (client_users.isEmpty()){
            return new ResponseResult(CommonCode.FAIL);
        }
        List<Client_user> clientUserList=new ArrayList<>();

        clientUserRepository.saveAll(client_users);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public ResponseResult EnableAndDisableuser(String id, String status) {
        Optional<Client_user> byId = clientUserRepository.findById(id);
        if (byId.isPresent()){
            Client_user client_user = byId.get();
            if (!client_user.getStatus().equals(status)){
                client_user.setStatus(status);
                clientUserRepository.save(client_user);
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult BathExportUser(List<String> id) {
        for (String ids:id){
            clientUserRepository.deleteById(ids);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult ResetPassword(String id, String password) {
        Optional<Client_user> byId = clientUserRepository.findById(id);
        if (byId.isPresent()){
            Client_user client_user = byId.get();
            if (!client_user.getPassword().equals(password)){
                client_user.setPassword(password);
                clientUserRepository.save(client_user);
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.SAME);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public Client_user login(Client_user user) {
        Client_user userLogin = clientUserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userLogin;
    }

    public Client_user getUser(String username){
        return clientUserRepository.findByUsername(username);
    }
}
