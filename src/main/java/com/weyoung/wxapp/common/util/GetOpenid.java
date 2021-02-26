package com.weyoung.wxapp.common.util;

public class GetOpenid {

    public String GetOpenid(String code) {
        //如果有code，说明是微信小程序，根据code获取openId
        //classify用于标识使用哪个小程序的授权码
        String openid = "{ErrorMsg:\"获取失败.\"}";
        if (code != null && code.trim().length() != 0) {
            openid = OpenIdUtil.oauth2GetOpenid(code);
        }

        return openid;
    }

}
