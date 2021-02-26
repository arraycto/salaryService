package com.weyoung.wxapp.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 非controller类获取http上下文的工具类
 */
public class HttpContextUtils {
    /**
     * 文件下载请求路径
     */
    public static final String DOWNLOAD_METHOD_URL = "/downloadFile/";

    private HttpContextUtils() {

    }

    /**
     * 获取当前会话的request对象
     *
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 根据文件名获取对应的http访问网址
     *
     * @param fileName
     * @return
     */
    public static String guessDownloadUrl(String fileName) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(DOWNLOAD_METHOD_URL)
                .path(fileName)
                .toUriString();
    }
}
