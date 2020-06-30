package com.server.UserControl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.UserControl.dao.UserAddRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.User;
import com.server.model.request.usercontrol.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    UserAddRepository userAddRepository;
    public ResponseResult add(user user) {

        User user1=new User();
        user1.setAccount(user.getAccount());
        user1.setPassword(user.getPassword());
        user1.setStart(1);
        user1.setLimits(1);
        userAddRepository.save(user1);

        return new ResponseResult(CommonCode.SUCCESS);
    }

    public ResponseResult userUser(String account) {

        Optional<User> byId = userAddRepository.findById(account);
        if (byId.isPresent()){
            User user = byId.get();
            user.setStart(1);
            userAddRepository.save(user);

            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult stopUser(String account) {

        Optional<User> byId = userAddRepository.findById(account);
        if (byId.isPresent()){
            User user = byId.get();
            user.setStart(0);
            userAddRepository.save(user);

            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult limitsUser(String account, Integer limits) {
        Optional<User> byId = userAddRepository.findById(account);
        if (byId.isPresent()){
            User user = byId.get();
            user.setLimits(limits);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public QueryResponseResult login(user user) {
        Optional<User> byId = userAddRepository.findById(user.getAccount());
        if (byId.isPresent()){
            User user1 = byId.get();
            if (user1.getPassword().equals(user.getPassword())){
                List<User> list=new ArrayList<>();
                list.add(user1);
                QueryResult queryResult = new QueryResult();
                queryResult.setList(list);
                return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
            }
            return new QueryResponseResult(CommonCode.falseaddUser,null);
        }
        return new QueryResponseResult(CommonCode.falseaddUser,null);

    }

    public QueryResponseResult getUserList(int page){
        PageHelper.startPage(page,8);
        List<User> all = userAddRepository.findAll();
        PageInfo pageInfo = new PageInfo(all,5);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
