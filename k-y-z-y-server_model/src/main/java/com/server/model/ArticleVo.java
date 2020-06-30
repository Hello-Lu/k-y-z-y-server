package com.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleVo implements Serializable {

    private Article article;
    private List<CommentsVo> commentsVos;
}
