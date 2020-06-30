package com.server.api.activity;

import com.server.common.model.response.ResponseResult;
import com.server.model.Activity;

public interface ActivityControlApi {
    public ResponseResult AddActivity(Activity activity);
    public ResponseResult DelActivity(String activityid);
    public ResponseResult UpdateActivity(Activity activity);;
}
