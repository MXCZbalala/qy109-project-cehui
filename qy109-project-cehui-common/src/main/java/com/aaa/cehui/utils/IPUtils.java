package com.aaa.cehui.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/9/21 8:51
 * @Description
 *    获取 IP地址
 * 	 使用 Nginx等反向代理软件， 则不能通过 request.getRemoteAddr()获取 IP地址
 * 	 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，
 * 	 X-Forwarded-For中第一个非 unknown的有效IP字符串，则为真实IP地址
 *
 **/
public class IPUtils {

    private static final String UNKNOWN = "unknown";

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}
