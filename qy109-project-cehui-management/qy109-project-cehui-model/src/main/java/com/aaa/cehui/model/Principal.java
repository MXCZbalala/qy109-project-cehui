package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_principal")
public class Principal implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 负责人类别
     */
    private String type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件类型
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 证件号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0:女 1:男 2:保密
     */
    private Integer sex;

    /**
     * 工作年限
     */
    @Column(name = "work_year")
    private Integer workYear;

    /**
     * 职务
     */
    private String duty;

    /**
     * 职称
     */
    private String title;

    /**
     * 从事测绘工作年限
     */
    @Column(name = "mapping_year")
    private Integer mappingYear;

    /**
     * 学历专业
     */
    private String major;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

}