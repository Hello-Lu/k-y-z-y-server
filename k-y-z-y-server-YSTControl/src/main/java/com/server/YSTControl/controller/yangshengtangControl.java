package com.server.YSTControl.controller;

import com.server.YSTControl.service.yangshengtangService;
import com.server.api.YangshengtangControl.YangshengtangControlApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.ArticleVo;
import com.server.model.InformationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/YST")
public class yangshengtangControl implements YangshengtangControlApi {
    @Autowired
    yangshengtangService yangshengtangService;

    /**
     * 信息类别管理，按分类查询
     * @param page
     * @param size
     * @param category
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}/{category}")
    public QueryResponseResult findclientuserList(@PathVariable("page")int page, @PathVariable("page")int size, @PathVariable("category")String category) {

        return yangshengtangService.findclientuserList(page,size,category);
    }

    @Override
    @PostMapping("/add")
    public ResponseResult addmessage(InformationCategory informationCategory) {
        return yangshengtangService.add(informationCategory);
    }

    @Override
    @PostMapping("/delete")
    public ResponseResult deletemessage(InformationCategory informationCategory) {
        return yangshengtangService.delete(informationCategory);
    }

    @Override
    @PostMapping("/update")
    public ResponseResult updatemessage(InformationCategory informationCategory) {
        return yangshengtangService.update(informationCategory);
    }


    @GetMapping("/article")
    public ArticleVo getArticle(@RequestParam("id") Integer id){

        return yangshengtangService.getArticleInfo(id);

    }
}
