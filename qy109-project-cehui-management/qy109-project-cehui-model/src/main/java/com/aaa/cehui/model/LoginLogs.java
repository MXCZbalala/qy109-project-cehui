package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;



import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_login_log")
public class LoginLogs {
    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 登录时间
     */
    @Column(name = "LOGIN_TIME")
    private String loginTime;

    /**
     * 登录地点
     */
    @Column(name = "LOCATION")
    private String location;

    /**
     * IP地址
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 操作类型
     */
    @Column(name = "OPERATION_TYPE")
    private String operationType;

    /**
     * 操作内容
     */
    @Column(name = "OPERATION_NAME")
    private String operationName;

}