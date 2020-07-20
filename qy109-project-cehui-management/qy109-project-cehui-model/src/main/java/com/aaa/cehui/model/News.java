package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_news")
public class News implements Serializable {
    private Long id;

    private String title;

    private String digest;
    @Column(name = "gmt_create")
    private String gmtCreate;
    @Column(name = "gmt_modified")
    private String gmtModified;

    private String body;

}