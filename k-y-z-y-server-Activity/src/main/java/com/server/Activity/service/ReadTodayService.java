package com.server.Activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.Activity.dao.ReadTodayRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.ReadToday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReadTodayService {

    @Autowired
    ReadTodayRepository readTodayRepository;
    public ResponseResult AddActivity(ReadToday readToday) {
        if (readToday!=null){
            readTodayRepository.save(readToday);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult DelReadToday(String readTodayid) {
        if (readTodayid!=null){
            readTodayRepository.deleteById(readTodayid);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult UpdateReadToday(ReadToday readToday) {
        if (readToday!=null){
            Optional<ReadToday> byId = readTodayRepository.findById(readToday.getId());
            if (byId.isPresent()){
                ReadToday readToday1 = byId.get();
                readToday1.setWatchingFocus(readToday.getWatchingFocus());
                readToday1.setUpdate_time(new Date());
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    public QueryResponseResult selectReadToady(int page){
        PageHelper.startPage(page,8);
        List<ReadToday> all = readTodayRepository.findAll();
        PageInfo pageInfo = new PageInfo(all,5);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
