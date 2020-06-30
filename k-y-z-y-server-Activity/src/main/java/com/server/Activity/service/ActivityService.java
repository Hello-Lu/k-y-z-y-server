package com.server.Activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.Activity.dao.ActivityRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    /**
     * 增加
     * @param activity
     * @return
     */
    public ResponseResult AddActivity(Activity activity) {

        if (activity!=null){
            activityRepository.save(activity);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }


    public ResponseResult DelActivity(String activityid) {
        if (activityid!=null){
            activityRepository.deleteById(activityid);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult UpdateActivity(Activity activity) {
        if (activity!=null){
            Optional<Activity> byId = activityRepository.findById(activity.getActivityid());
            if (byId.isPresent()){
                Activity activity1 = byId.get();
                activity1.setActivity(activity.getActivity());
                activityRepository.save(activity1);
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    public QueryResponseResult ActivityList(int page){
        PageHelper.startPage(page,8);
        List<Activity> all = activityRepository.findAll();
        PageInfo pageInfo = new PageInfo(all,5);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        QueryResponseResult<Object> queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
