package com.aaa.cehui.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:47
 * @Description
 **/
@Data
public class User implements Serializable {

    private String id;
    private String username;
    private String password;

}
