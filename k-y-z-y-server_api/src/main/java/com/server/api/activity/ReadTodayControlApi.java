package com.server.api.activity;

import com.server.common.model.response.ResponseResult;
import com.server.model.ReadToday;

public interface ReadTodayControlApi {
    public ResponseResult AddReadToday(ReadToday readToday);
    public ResponseResult DelReadToday(String ReadTodayid);
    public ResponseResult UpdateReadToday(ReadToday readToday);
}
