package com.server.api.picture;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Comments;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface PictureControlApi {
    public ResponseResult pictureAdd(MultipartFile file);
    public QueryResponseResult pictureFindList(int page, int size);
    public ResponseResult pictureDele(String id);
}
