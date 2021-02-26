package com.weyoung.wxapp.welfare.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weyoung.wxapp.common.controller.BaseController;
import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/***
 * @author li
 * @date 2019-11-19
 */
@Api(tags = "商品管理")
@RestController
@RequestMapping("goods")
public class GoodsController extends BaseController {
    @Autowired
    private GoodsService goodsService;
    @ApiOperation("获取商品种类")
    @PostMapping("/category")
    @ResponseBody
    public JsonResult category(){
        JsonResult result = ResponseUtil.ok();
        result.setData(goodsService.getCategory());
        return result;
    }

    @ApiOperation("获取商品列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonResult getNewsList(@RequestParam Integer categoryId,
                                  @NotNull @RequestParam Integer pageSize,
                                  @NotNull @RequestParam Integer pageNum) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        JsonResult result = ResponseUtil.ok();
        result.setRows(goodsService.goodsList(categoryId));
        result.setTotal((int) page.getTotal());
        return result;
    }

    @PostMapping("/detail")
    @ResponseBody
    public JsonResult see(@RequestParam("goodsId") Integer goodsId,
                          @NotNull @RequestParam Integer pageSize,
                          @NotNull @RequestParam Integer pageNum) {
        JsonResult result = ResponseUtil.ok();
        result.setData(goodsService.seeGoods(goodsId));
        return result;
    }

    @PostMapping("/search")
    @ResponseBody
    public JsonResult search(@NotNull @RequestParam("goodsName") String goodsName,
                             @NotNull @RequestParam Integer pageSize,
                             @NotNull @RequestParam Integer pageNum) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        JsonResult result = ResponseUtil.ok();
        result.setRows(goodsService.search(goodsName));
        result.setTotal((int) page.getTotal());
        return result;
    }
}
