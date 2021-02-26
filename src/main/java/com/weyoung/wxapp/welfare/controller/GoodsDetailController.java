package com.weyoung.wxapp.welfare.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.service.GoodsDetailService;
import com.weyoung.wxapp.welfare.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author li
 * @date 2019-11-29
 */
@RestController
@RequestMapping("detail")
public class GoodsDetailController {
    @Autowired
    GoodsDetailService GoodsDetailService;

    @PostMapping("/detail")
    @ResponseBody
    public JsonResult detail(@NotNull @RequestParam("goodsId") Integer goodsId){
        JsonResult result = ResponseUtil.ok();
        result.setData(GoodsDetailService.detail(goodsId));
        return result;
    }

}
