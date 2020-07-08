package com.aaa.cehui.base;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:38
 * @Description
 **/
public abstract class CommonController<T> extends BaseController {

    public abstract  BaseService<T> getBaseService();

    public ResultData add(Map map) {
        return new ResultData();
    }

}
