package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: qy109-project-cehui
 * @description:    抽查人员信息表
 * @author: Mr.Wang
 * @create: 2020-07-20 20:03
 **/
@Table(name = "t_check_person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CheckPerson implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 单位姓名
     */
    @Column(name = "unit_name")
    private String unit_name;
    /**
     * 职务
     */
    private String duty;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String create_time;
    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modify_time;
    /**
     * 备注
     */
    private String memo;
}
