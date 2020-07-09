package com.aaa.cehui.base;

import static com.aaa.cehui.status.LoginStatus.*;
import static com.aaa.cehui.status.OperationStatus.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:11
 * @Description
 *      统一controller
 *      也就是说所有的controller都需要继承这个controller，进行统一返回
 *
 *      eg:
 *          登录成功和失败
 *          code:200 msg:登录成功
 *          code:400 msg:登录失败，系统异常
 *          code:201 msg:用户已经存在
 *          code:401 msg:用户不存在
 *          code:402 msg:密码错误
 *          code:405 msg:用户退出异常
 *
 **/
public class BaseController {

    /**
     * @author Seven Lee
     * @description
     *      登录成功
     *      使用系统消息
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功
     *      自定义返回消息
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功
     *      返回数据信息，使用系统消息
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功
     *      返回数据信息，自定义消息
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，使用系统消息
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，使用系统消息，详细解释说明
     * @param []
     * @date 2020/7/8
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作失败，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    // TODO 代码未完善，记得补充





}
