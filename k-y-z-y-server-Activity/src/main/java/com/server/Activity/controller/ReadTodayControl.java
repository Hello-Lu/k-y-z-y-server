package com.server.Activity.controller;

import com.server.Activity.service.ReadTodayService;
import com.server.api.activity.ReadTodayControlApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.ReadToday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ReadToday")
public class ReadTodayControl implements ReadTodayControlApi {

    @Autowired
    ReadTodayService readTodayService;
    /**
     * 今日热点增删改查
     */
    @Override
    @PostMapping("/add")
    public ResponseResult AddReadToday(ReadToday readToday) {
        return readTodayService.AddActivity(readToday);
    }
    @Override
    @PostMapping("/Dele")
    public ResponseResult DelReadToday(String ReadTodayid) {
        return readTodayService.DelReadToday(ReadTodayid);
    }

    @Override
    @PostMapping("/Update")
    public ResponseResult UpdateReadToday(ReadToday readToday) {
        return readTodayService.UpdateReadToday(readToday);
    }

    @GetMapping("/list")
    public QueryResponseResult SelectReadToady(@RequestParam(value = "page",defaultValue = "1") int page){
        return readTodayService.selectReadToady(page);
    }
}
