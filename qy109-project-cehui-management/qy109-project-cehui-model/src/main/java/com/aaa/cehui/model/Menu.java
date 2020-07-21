package com.aaa.cehui.model;

import com.aaa.cehui.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/17  18:02
 * @Description
 *      菜单表
 **/
@Table(name = "t_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Menu implements Serializable {

    /**
     * 菜单ID
     */
    @Column(name = "MENU_ID")
    private Long menuId;



    /**
     * 上级菜单ID
     */
    @Column(name = "PARENT_ID")
    private Long parentId;



    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;


    /**
     * 对应路由path
     */
    @Column(name = "PATH")
    private String path;


    /**
     * 对应路由组件component
     */
    @Column(name = "COMPONENT")
    private String component;

    /**
     * 权限标识
     */
    @Column(name = "PERMS")
    private String perms;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 类型 0菜单  1 按钮
     */
    @Column(name = "TYPE")
    private Integer type;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    @Column(name = "create_time")
    @Max(value = 100, message = "时间长度最长不能超过100")
    private String createTime;

    @Column(name = "modify_time")
    @Max(value = 100, message = "时间长度最长不能超过100")
    private String modifyTime;

    private List<Menu> subMenu;




}
