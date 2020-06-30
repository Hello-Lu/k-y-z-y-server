package com.server.YSTControl.controller;

import com.alibaba.fastjson.JSON;
import com.server.YSTControl.service.CommentsService;
import com.server.api.CommentsControl.CommentsControlAPI;
import com.server.common.model.response.ResponseResult;
import com.server.model.Comments;
import com.server.utils.XcOauth2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Comment")
public class CommentsControl implements CommentsControlAPI {

    @Autowired
    CommentsService commentsService;

    /**
     * 添加评论
     * @param comments 传递到评论和养生堂信息id
     * @return
     */
    @Override
    @PostMapping("/add")
    public ResponseResult addType1(Comments comments){

        return commentsService.addType1(comments);
    }


}
