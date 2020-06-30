package com.server.api.UserControl;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.Response;
import com.server.common.model.response.ResponseResult;
import com.server.model.request.usercontrol.user;

public interface UserControl {
    public ResponseResult addUser(user user);
    public ResponseResult useUser(String account);
    public ResponseResult stopUser(String account);
    public ResponseResult limitsUser(String account,Integer limits);
    public QueryResponseResult login(user user);
}
