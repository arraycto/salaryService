package com.weyoung.wxapp.welfare.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weyoung.wxapp.common.controller.BaseController;
import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.HttpUtil;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.domain.OrdersDetail;
import com.weyoung.wxapp.welfare.domain.RepairDetail;
import com.weyoung.wxapp.welfare.domain.User;
import com.weyoung.wxapp.welfare.service.LoginService;
import com.weyoung.wxapp.welfare.vo.SourceVo;
import com.weyoung.wxapp.welfare.vo.UploadVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author li
 * @date 2019-11-24
 */
@Api("用户信息")
@RestController
@RequestMapping("user")
public class LoginController extends BaseController {
    @Autowired
    LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public JsonResult login(@ApiParam(value = "小程序JS_CODE", required = true, example = "5TYJKL%^&")
                            @NotNull @RequestParam String jsCode,
                            @RequestParam Integer recommenderId,
                            @RequestParam("userName") String userName) {
        String openid = "5TYJKL%^&".equals(jsCode) ? "li" : parseOpenid(jsCode);
        User user = loginService.login(openid, userName, recommenderId);
        JsonResult result = ResponseUtil.ok();
        result.setData(user);
        return result;
    }
    @ApiOperation("师傅取消订单")
    @PostMapping("/cancel")
    public JsonResult cancel(@NotNull @RequestParam Integer repairId,
                             @NotNull @RequestParam Integer state,
                             @RequestParam String description){
        //state==1表示师傅端取消的是预约订单，state == 0表示取消的是用户下单的订单
        if ( loginService.cancel(repairId, description, state) > 0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }
    @ApiOperation("用户查询订单")
    @PostMapping("/query")
    public JsonResult query(@NotNull @RequestParam Integer userId,
                            @NotNull @RequestParam Short state,
                            @NotNull @RequestParam Integer pageSize,
                            @NotNull @RequestParam Integer pageNum){
        Page page = PageHelper.startPage(pageNum, pageSize);
        JsonResult result = ResponseUtil.ok();
        result.setRows(loginService.query(userId, state));
        result.setTotal((int) page.getTotal());
        return result;
    }
    @ApiOperation("师傅查询派单")
    @PostMapping("/dispatch")
    public JsonResult dispatch(@NotNull @RequestParam Integer userId,
                               @NotNull @RequestParam Short state,
                               @NotNull @RequestParam Integer pageSize,
                               @NotNull @RequestParam Integer pageNum){
        Page page = PageHelper.startPage(pageNum, pageSize);
        JsonResult result = ResponseUtil.ok();
        result.setRows(loginService.dispatch(userId, state));
        result.setTotal((int) page.getTotal());
        return result;
    }

    @ApiOperation("师傅查询订单详情")
    @PostMapping("/detail")
    public JsonResult detail(@NotNull @RequestParam Integer repairId,
                             @NotNull @RequestParam Short state){
        //state==1表示师傅端取消的是预约订单，state == 0表示取消的是用户下单的订单
        return loginService.detail(repairId, state);
    }

    @ApiOperation("师傅上传购买订单")
    @PostMapping("/uploadOrder")
    public JsonResult uploadOrder(UploadVo uploadVo){
        if (loginService.uploadOrder(uploadVo) > 0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }
    @ApiOperation("师傅上传预约维修订单")
    @PostMapping("/uploadRepair")
    public JsonResult uploadRepair(UploadVo uploadVo){
        loginService.uploadRepair(uploadVo);
        return ResponseUtil.ok();
    }

    @ApiOperation("用户或师傅通过电话查询信息")
    @PostMapping("/userQuery")
    public JsonResult userQuery(@NotNull @RequestParam String tel,
                                @NotNull @RequestParam Integer pageSize,
                                @NotNull @RequestParam Integer pageNum){
        Page page = PageHelper.startPage(pageNum, pageSize);
        JsonResult result = ResponseUtil.ok();
        result.setRows(loginService.userQuery(tel));
        result.setTotal((int) page.getTotal());
        return result;
    }

    @ApiOperation("师傅上传自己接得单")
    @PostMapping("/uploadAdmin")
    public JsonResult uploadAdmin(SourceVo sourceVo){
        if (loginService.uploadAdmin(sourceVo) > 0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }

    @ApiOperation("服务列表")
    @PostMapping("/serviceList")
    public JsonResult serviceList(@NotNull @RequestParam Integer serviceId){
        JsonResult result = ResponseUtil.ok();
        result.setData(loginService.serviceList(serviceId));
        return result;
    }

    @ApiOperation("被推荐人列表")
    @PostMapping("/recommenderList")
    public JsonResult recommenderList(@NotNull @RequestParam Integer userId){
        JsonResult result = ResponseUtil.ok();
        result.setData(loginService.recommenderList(userId));
        return result;
    }
    @ApiOperation("签到")
    @PostMapping("/signIn")
    public JsonResult signIn(@NotNull @RequestParam Integer userId){
        JsonResult result = ResponseUtil.ok();
        result.setData(loginService.signIn(userId));
        return result;
    }
    @ApiOperation("获取qrcode")
    @PostMapping("/qrcode")
    @ResponseBody
    public byte[] getToken(@NotNull @RequestParam Integer userId) throws IOException {
        String appid = "wxe56110daccdfcca7";
        String appsecret = "ec314bc7fd7f50417d98aa7e730caab6";

        //授权（必填）
        String grant_type = "client_credential";
        //URL
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token";
        //请求参数
        String params = "grant_type=" + grant_type + "&appid=" + appid + "&secret=" + appsecret;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        JSONObject jsonObject = JSONObject.parseObject(data);
        String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + jsonObject.get("access_token");

        JSONObject json = new JSONObject();
        json.put("scene","userId=" + userId);
        return HttpUtil.post(url, json);
    }
    @ApiOperation("修改个人信息")
    @PostMapping("/updatePersonal")
    public JsonResult updatePersonal(@NotNull @RequestParam Integer userId,
                                     String username,
                                     String tel,
                                     String email){
        JsonResult result = ResponseUtil.ok();
        result.setData(loginService.updatePersonal(userId,username,tel,email));
        return result;
    }

    @ApiOperation("上下班")
    @PostMapping("/work")
    public JsonResult work(User user){
        JsonResult result = ResponseUtil.ok();
        result.setData(loginService.work(user));
        return result;
    }
}
