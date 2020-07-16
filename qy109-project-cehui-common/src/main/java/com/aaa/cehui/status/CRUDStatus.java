package com.aaa.cehui.status;

/**
 * @Author ltl
 * @Date 2020/7/16  9:34
 * @Description
 **/
public enum CRUDStatus {

    FIND_SUCCESS("201", "操作成功"),
    FIND_FILED("402", "操作失败"),
    ADD_SUCCESS("203", "添加成功"),
    ADD_FILED("440", "添加失败"),
    UPDATE_SUCCESS("205","修改成功"),
    UPDATE_FILED("406","修改失败"),
    DELETE_SUCCESS("207","删除成功"),
    DELETE_FILED("408","删除失败");

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
