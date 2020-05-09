package com.zimingsir.support.Util;

/**
 * @Description: 定义一些要用的常量
 * @Author: 欧阳能达
 * @Created: 2020年04月19日 10:43:00
 **/
public class VariableUtil {
    // 用户本地购物车的生存时间，单位是秒，时长为两个月
    public static final Integer LOCAL_CART_LIVE_TIME = new Integer(2 * 30 * 24 * 60 * 60);

    // 本地购物车在Cookie中的名称
    public static final String LOCAL_CART_NAME = "localcart";

    // token的有效时长，用毫秒表示，设置为24小时
    public static final Long TOKEN_LIVE_TIME = new Long(24 * 60 * 60 * 1000);
}
