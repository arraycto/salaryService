package com.weyoung.wxapp.welfare.controller;


import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author xie
 * @date 2021-2-7
 */

@Api(tags = "工资管理")
@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    private ResponseUtil ResponseBo;




    @ApiOperation("获取工资列表")
    @PostMapping("/getsalary")
    @ResponseBody
    public JsonResult getSalary(){
        JsonResult result = ResponseUtil.ok();
        result.setData(salaryService.getSalary());
        return result;
    }
    @ApiOperation("日常打卡")
    @PostMapping("/decard")
    @ResponseBody


    public JsonResult decard(@NotNull @RequestParam Integer time,@NotNull @RequestParam Integer workId,
                             @NotNull @RequestParam String word) {

        int salary = salaryService.decard(time,workId,word);
        JsonResult result = ResponseUtil.ok();
        result.setData(salary);
        return  result;

    }
}
