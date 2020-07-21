package com.aaa.cehui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.Date;
@Table(name = "t_score")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Score {
    private Long id;

    private Integer scorePlus;

    private Integer scoreSubtract;

    private Integer score;

    private Long unitId;

    private String reason;

    private Date createTime;

    private Date modifyTime;

}