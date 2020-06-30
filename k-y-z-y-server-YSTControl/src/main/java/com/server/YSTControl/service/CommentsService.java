package com.server.YSTControl.service;

import com.server.YSTControl.dao.CommentsRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.ResponseResult;
import com.server.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;


    public ResponseResult addType1(Comments commentsVo) {

        Date date = new Date();
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        commentsVo.setCreate_time(sdft.format(date));
        commentsRepository.save(commentsVo);
        return new ResponseResult(CommonCode.SUCCESS);
    }

}
