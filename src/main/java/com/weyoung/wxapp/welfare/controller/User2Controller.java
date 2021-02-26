package com.weyoung.wxapp.welfare.controller;


import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.domain.User2;
import com.weyoung.wxapp.welfare.service.UserpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xie
 * @date 2021-2-7
 */

@Api(tags = "用户管理252")
@RestController
@RequestMapping("first")
public class User2Controller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserpService userpService;
    private ResponseUtil ResponseBo;


    @ApiOperation("获取用户列表")
    @PostMapping("/user2")
    @ResponseBody
    public JsonResult getUser(){
        JsonResult result = ResponseUtil.ok();
        result.setData(userpService.userList());
        return result;
    }
    @ApiOperation("查询用户")
    @PostMapping("/search")
    @ResponseBody

    public JsonResult search(@RequestParam Integer workId,@RequestParam Integer phone,
                             @RequestParam Integer name, @RequestParam Integer salary,@RequestParam String username){
        JsonResult result = ResponseUtil.ok();
        result.setData(userpService.search(workId,phone,name,salary,username));
        return result;
    }


    @ApiOperation("获取日志列表")
    @PostMapping("/getcard")
    @ResponseBody
    public JsonResult getcard(){
        JsonResult result = ResponseUtil.ok();
        result.setData(userpService.getcard());
        return result;
    }
    @ApiOperation("登录")
    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(@NotNull @RequestParam  String username,
                            @NotNull @RequestParam Integer password) {

        User2 user2 = userpService.login(username, password);
        JsonResult result = ResponseUtil.ok();
        result.setData(user2);

        if (null != user2) {
            return result;
        }
        return ResponseUtil.fail();

    }

    @ApiOperation("新增用户")
    @PostMapping("/insertuser")
    @ResponseBody


    public JsonResult insertuser(@NotNull @RequestParam  String username,
                             @NotNull @RequestParam  String name,
                             @NotNull @RequestParam  Integer dept,
                             @NotNull @RequestParam  Integer workId,
                             @NotNull @RequestParam Integer password) {

        int user2 = userpService.insertuser(username, password,name,dept,workId);
        JsonResult result = ResponseUtil.ok();
        result.setData(user2);
        return  result;

    }
    @ApiOperation("注册")
    @PostMapping("/regist")
    @ResponseBody


    public JsonResult regist(@NotNull @RequestParam  String username,
                            @NotNull @RequestParam Integer password) {

         int user2 = userpService.regist(username, password);
        JsonResult result = ResponseUtil.ok();
        result.setData(user2);
        return  result;

    }

    @ApiOperation("分配用户")
    @PostMapping("/gitUser")
    @ResponseBody


    public JsonResult gitUser(@NotNull @RequestParam  Integer dept,@NotNull @RequestParam  Integer workId) {

        int user2 = userpService.gitUser(dept,workId);
        JsonResult result = ResponseUtil.ok();
        result.setData(user2);
        return  result;

    }

    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    @ResponseBody


    public JsonResult deleteUser( @RequestParam  Integer workId) {

        int user2 = userpService.deleteUser(workId);
        JsonResult result = ResponseUtil.ok();
        result.setData(user2);
        return  result;

    }
}
