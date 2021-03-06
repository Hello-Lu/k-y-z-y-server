package com.server.common.model.response;

/**
 * Created by mrt on 2018/3/5.
 *返回是否成功
 * 操作代码
 * 提示信息
 */
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}
