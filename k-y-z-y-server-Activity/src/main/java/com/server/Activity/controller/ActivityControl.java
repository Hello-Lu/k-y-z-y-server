package com.server.Activity.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.Activity.service.ActivityService;
import com.server.api.activity.ActivityControlApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityControl implements ActivityControlApi {


    @Autowired
    ActivityService activityService;
    /**
     * 活动增删改查
     */
    @Override
    @PostMapping("/add")
    public ResponseResult AddActivity(Activity activity) {
        return activityService.AddActivity(activity);
    }

    @Override
    @PostMapping("/Dele")
    public ResponseResult DelActivity(@RequestParam("activityid") String activityid) {
        return activityService.DelActivity(activityid);
    }
    @PostMapping("/Update")
    public ResponseResult UpdateActivity(Activity activity){
        return activityService.UpdateActivity(activity);
    }


    @GetMapping("/list")
    public QueryResponseResult SelectActivity(@RequestParam(value = "page",defaultValue = "1") int page){
        return activityService.ActivityList(page);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
