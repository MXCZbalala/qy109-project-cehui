package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ltl
 * @Date 2020/7/17  18:26
 * @Description
 *      用户角色中间表
 **/
@Table(name = "t_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserRole implements Serializable {
    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private Long userId;


    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Long roleId;
}
