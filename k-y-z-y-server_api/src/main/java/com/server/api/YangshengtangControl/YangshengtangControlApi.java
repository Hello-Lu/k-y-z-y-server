package com.server.api.YangshengtangControl;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.InformationCategory;

public interface YangshengtangControlApi {
    public QueryResponseResult findclientuserList(int page, int size,String category);
    public ResponseResult addmessage(InformationCategory informationCategory);
    public ResponseResult deletemessage(InformationCategory informationCategory);
    public ResponseResult updatemessage(InformationCategory informationCategory);
}
