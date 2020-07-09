package com.aaa.cehui.model;/**
 * @Auther: 吴超
 * @Date: 2020/5/29 11:22
 * @Description:
 */

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * @Auther: 吴超
 * @Date: 2020/5/29 11:22
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuInfo   {
    private BigInteger id;
    private BigInteger PARENT_ID;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(BigInteger PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

}
