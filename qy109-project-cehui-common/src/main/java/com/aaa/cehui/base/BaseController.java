package com.aaa.cehui.base;



import java.sql.PreparedStatement;

import static com.aaa.cehui.status.LoginStatus.*;
import static com.aaa.cehui.status.OperationStatus.*;
import static com.aaa.cehui.status.CRUDStatus.*;

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

    /**
    * @Author LTL
    * @Description 查询成功 返回数据信息
    * @Param
    * @Return
    * @DateTime 2020/7/16  9:32
    * @Throws
    */
    protected ResultData getSuccess(Object object){
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(GET_SUCCESS.getCode());
        resultData.setMsg(GET_SUCCESS.getMsg());
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 查询失败
    * @Param [object]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:38
    * @Throws
    */
    protected ResultData getFiled(){
        ResultData resultData = new ResultData();
        resultData.setCode(GET_FAILED.getCode());
        resultData.setMsg(GET_FAILED.getMsg());
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 查询失败  返回自定义消息
    * @Param [msg]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:42
    * @Throws
    */
    protected ResultData getFiled(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(GET_FAILED.getCode());
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 修改成功
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:53
    * @Throws
    */
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 修改成功 返回数据
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:43
    * @Throws
    */
    protected ResultData updateSuccess(Object object){
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
    * @Author LTL
    * @Description 修改成功，返回自定义消息
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:45
    * @Throws
    */
    protected ResultData updateSuccess(Object object,String msg){
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
    * @Author LTL
    * @Description 修改失败
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:45
    * @Throws
    */
    protected ResultData updateFiled(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @Author LTL
     * @Description 增加成功
     * @Param [object]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  10:46
     * @Throws
     */
    protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }
    /**
    * @Author LTL
    * @Description 增加成功 ，返回数据
    * @Param [object]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:46
    * @Throws
    */
    protected ResultData addSuccess(Object object){
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Author LTL
     * @Description 增加成功 ，返回数据,返回自定义消息
     * @Param [object]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  10:46
     * @Throws
     */
    protected ResultData addSuccess(Object object,String msg){
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 增加失败
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:47
    * @Throws
    */
    protected ResultData addFiled(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 增加失败，返回自定义消息
    * @Param [msg]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:48
    * @Throws
    */
    protected ResultData addFiled(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 删除成功
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:48
    * @Throws
    */
    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author LTL
     * @Description 删除成功 返回自定义消息
     * @Param []
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  10:48
     * @Throws
     */
    protected ResultData deleteSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
    * @Author LTL
    * @Description 删除失败
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  10:49
    * @Throws
    */
    protected ResultData deleteFiled(){
        ResultData resultData = new ResultData();
        resultData.setCode(DElETE_FAILED.getCode());
        resultData.setMsg(DElETE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author LTL
     * @Description 删除失败 返回自定义消息
     * @Param []
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  10:49
     * @Throws
     */
    protected ResultData deleteFiled(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DElETE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }





}
