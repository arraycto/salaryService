package com.weyoung.wxapp.welfare.controller;

import com.weyoung.wxapp.common.controller.BaseController;
import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.common.util.SendEmailUtil;
import com.weyoung.wxapp.common.util.SendSmsUtil;
import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tools.ant.types.selectors.OrSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author li
 * @date 2019-12-02
 */
@Api(tags = "用户下单")
@RestController
@RequestMapping("orders")
public class OrdersController extends BaseController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    private JavaMailSender mailSender;
    @ApiOperation("下单")
    @PostMapping("/orders")
    @ResponseBody
    public JsonResult orders(Orders orders) throws Exception {
        ordersService.orders(orders);
        SendSmsUtil.Send(orders.getGoodsName(), orders.getUserName(), orders.getTel(), orders.getAddress());
//        SendEmailUtil.send(mailSender,"商品", orders.getGoodsName(), orders.getTel(),
//                orders.getUserName(), orders.getAddress());
        return ResponseUtil.ok();
    }
}
