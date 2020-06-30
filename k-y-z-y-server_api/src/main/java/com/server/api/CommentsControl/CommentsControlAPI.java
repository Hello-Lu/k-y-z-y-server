package com.server.api.CommentsControl;

import com.server.common.model.response.ResponseResult;
import com.server.model.Comments;

import java.util.List;

public interface CommentsControlAPI {
    public ResponseResult addType1(Comments comments);
}
