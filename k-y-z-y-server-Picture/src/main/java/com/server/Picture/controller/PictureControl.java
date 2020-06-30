package com.server.Picture.controller;

import com.server.Picture.service.PictureService;
import com.server.api.picture.PictureControlApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Picture")
public class PictureControl implements PictureControlApi {

    @Autowired
    PictureService pictureService;
    @Override
    /**
    添加图片，
     */
    @PostMapping("/add")
    public ResponseResult pictureAdd(@RequestParam("file") MultipartFile file) {
        return pictureService.pictureAdd(file);
    }


    /**
     * 返回图片的地址url
     */
    @Override
    @GetMapping("/find/{page}/{size}")
    public QueryResponseResult pictureFindList(@PathVariable("page") int page,@PathVariable("size") int size) {
        return pictureService.pictureFindList(page,size);
    }
    /**
     * 删除图片
     */
    @PostMapping("/delete")
    @Override
    public ResponseResult pictureDele(@RequestParam("id") String id) {
        return pictureService.pictureDele(id);
    }





}
