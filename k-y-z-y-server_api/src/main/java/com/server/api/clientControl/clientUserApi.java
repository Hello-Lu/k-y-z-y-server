package com.server.api.clientControl;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Client_user;

import java.util.List;

public interface clientUserApi {
    public QueryResponseResult findclientuserList(int page,int size);
    public ResponseResult addbatchUser(List<Client_user> client_user);
    public ResponseResult EnableAndDisableuser(String id,String Status);
    public ResponseResult BatchExportUser(List<String> id);
    public ResponseResult ResetPassword(String id,String password);
}
