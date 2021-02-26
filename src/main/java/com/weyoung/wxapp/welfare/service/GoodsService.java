package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.Category;
import com.weyoung.wxapp.welfare.domain.Goods;
import com.weyoung.wxapp.welfare.vo.GoodsVo;

import java.util.List;

/**
 * @author li
 * @date 2019-11-19
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 获取商品种类
     * @return
     */
    List<Category> getCategory();

    /**
     * 根据商品类别获取商品
     * @param categoryId
     * @return
     */
    List<Goods> goodsList(Integer categoryId);

    /**
     * 查看商品详情
     * @param goodsId
     * @return
     */
    GoodsVo seeGoods(Integer goodsId);

    /**
     * 搜索商品
     */
    List<Goods> search(String goodsName);
}
