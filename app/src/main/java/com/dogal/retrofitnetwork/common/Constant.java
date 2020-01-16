package com.dogal.retrofitnetwork.common;

/**
 * @author Dogal
 * @date  2020/01/01
 */

public class Constant {
    public static final String BASE_URL = "http://www.searchauto.net/system/";
    public static final String BASE_URL2 = "http://www.searchauto.net/system/";
    public static final String APK_PATH = "";
    public static final int PARAM_REQUEST = 1;//普通参数方式
    public static final int MAP_REQUEST = 2;//map集合方式
    public static final int FILE_REQUEST = 3;//单文件(头像、图片等)
    public static final int FILES_REQUEST = 4;//多文件(头像、图片等)
    public static final int LIST_REQUEST = 5;//list请求
    public static final int POST_REQUEST = 6;//post请求

    public static final int PIC_CHOOSE_SINGLE = 1;//选择单张图片
    public static final int PIC_CHOOSE_MORE = 2;//选择多张图片
    public static final int PIC_CHOOSE_MIN_NUM = 1;//最小选择图片数
    public static final int PIC_CHOOSE_MAX_NUM = 9;//最大选择图片数

    //三方天气接口  https://wx.jdcloud.com/market/api/10610
    //TODO  最好自己注册哈
    public static String WEATHER = "https://way.jd.com/he/";
    public static final String WEATHER_KEY = "5f238d5d25be10789ae2b46689b157fc";
}
