package com.aaa.cehui.status;

/**
 * @Author ltl
 * @Date 2020/7/16  9:34
 * @Description
 **/
public enum CRUDStatus {
    //增删改查
    GET_SUCCESS("20001","获取数据成功"),
    GET_FAILED("10001","获取数据失败"),
    ADD_SUCCESS("20002","新增数据成功"),
    ADD_FAILED("10002","新增数据失败"),
    UPDATE_SUCCESS("20003","更改数据成功"),
    UPDATE_FAILED("10003","更改数据失败"),
    DELETE_SUCCESS("20004","删除数据成功"),
    DElETE_FAILED("10004","删除数据失败"),
    UPLOAD_SUCCESS("20005","文件上传成功"),
    UPLOAD_FAILED("10005","文件上传失败");

    private String code;
    private String msg;

    CRUDStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    }
