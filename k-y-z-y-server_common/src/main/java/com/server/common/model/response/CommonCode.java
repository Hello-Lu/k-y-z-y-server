package com.server.common.model.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode{
    INVALID_PARAM(false,10003,"参数非法"),
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    SAME(false,11112,"修改密码失败，与原密码相同！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    falseaddUser(false,10003,"您的密码和确认密码不相符，请重试"),
    trueaddUser(true,10004,"创建成功，请重新登入"),
    updatepassword(false,10005,"您的原始密码错误，请重试"),
    updatepasswordtrue(true,10006,"修改成功，请重新登入"),
    LOGINTURE(true,10007,"登入成功"),
    LOGINFALSE(false,10008,"管理员或账户或密码错误，请重试");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
