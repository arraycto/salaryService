package com.weyoung.wxapp.common.util;



public class OpenIdUtil {
    public static String oauth2GetOpenid(String code) {
        String appid = "wxe56110daccdfcca7";
        String appsecret = "ec314bc7fd7f50417d98aa7e730caab6";

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        return data;
    }
}
