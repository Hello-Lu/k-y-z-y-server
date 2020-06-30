package com.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CommentsVo implements Serializable {

    private Client_user fromUser;
    private Client_user toUser;
    private String comment;
    private String createTime;
    private List<CommentsVo> commentsVos;
}

@Data
class Reply implements Serializable{
    private Client_user fromUser;
    private Client_user toUser;
    private String comment;
    private String createTime;
}
