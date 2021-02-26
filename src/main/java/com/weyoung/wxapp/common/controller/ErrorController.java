package com.weyoung.wxapp.common.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Pushy
 * @since 2018/11/21 13:31
 */
@RestController
public class ErrorController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/401", produces = "application/json")
    public JsonResult unauthorized(HttpServletRequest request) {
        String errMsg = null;
        try {
            errMsg = URLDecoder.decode(request.getParameter("errMsg"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //
        }
        logger.info("errMsg={}", errMsg);
        JsonResult jsonResult = ResponseUtil.buildResult(ResponseUtil.NOT_LOGIN);
        if (errMsg != null) {
            jsonResult.setMsg(errMsg);
        }
        return jsonResult;
    }

}
