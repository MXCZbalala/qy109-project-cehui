package com.aaa.cehui.utils;

import java.util.Random;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/10 11:47
 * @Description
 **/
public class FileNameUtils {

    private FileNameUtils() {

    }

    /**
     * @author Seven Lee
     * @description
     *      文件名的生成
     * @param []
     * @date 2020/7/10
     * @return java.lang.String
     * @throws
    **/
    public static String getFileName() {
        // 1.获取当前系统时间的毫秒数
        long currentTimeMillis = System.currentTimeMillis();
        // 2.创建随机数对象
        Random random = new Random();
        // 3.随机 从0-999之间随机
        int number = random.nextInt(999);
        // 4.生成最终的文件名
        /**
         * format():
         *      格式化方法
         *      %:占位符
         *      03:三位，如果不够三位则向前补0
         *      0-999随机---->11--->011
         *      --->9--->009
         *      d:数字
         */
        return currentTimeMillis + String.format("%03d", number);
    }

}
