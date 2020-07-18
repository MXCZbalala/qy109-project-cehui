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
 * @Date 2020/7/17  18:27
 * @Description
 *      角色权限中间表
 **/
@Table(name = "t_role_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleMenu implements Serializable {
    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Long roleId;


    /**
     * 菜单ID
     */
    @Column(name = "MENU_ID")
    private Long menuId;
}
