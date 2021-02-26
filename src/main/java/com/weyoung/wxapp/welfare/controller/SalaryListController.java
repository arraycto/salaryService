package com.weyoung.wxapp.welfare.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.domain.SalaryList;
import com.weyoung.wxapp.welfare.service.SalaryListService;
import com.weyoung.wxapp.welfare.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author xie
 * @date 2021-2-7
 */

@Api(tags = "扣款管理")
@RestController
@RequestMapping("salaryList")
public class SalaryListController {


    @Autowired
    private SalaryListService salaryListService;


    @ApiOperation("获取扣款列表")
    @PostMapping("/getsalaryList")
    @ResponseBody
    public JsonResult getList(){
        JsonResult result = ResponseUtil.ok();
        result.setData(salaryListService.getList());
        return result;
    }


    @ApiOperation("扣款申诉")
    @PostMapping("/reget")
    @ResponseBody
    public JsonResult reget(@NotNull @RequestParam String word,@RequestParam Integer workId) {

        int reget = salaryListService.reget(word,workId);
        JsonResult result = ResponseUtil.ok();
        result.setData(reget);
        return  result;

    }

    @ApiOperation("扣款新增")
    @PostMapping("/insertcost")
    @ResponseBody
    public JsonResult insertcost(@NotNull @RequestParam String word,@RequestParam Integer workId,
                                 @RequestParam Integer money) {

        int insertcost = salaryListService.insertcost(word,workId,money);
        JsonResult result = ResponseUtil.ok();
        result.setData(insertcost);
        return  result;

    }
}
