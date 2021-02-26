package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.GoodsDetail;
import com.weyoung.wxapp.welfare.vo.GoodsVo;

/**
 * @author li
 * @date 2019-11-29
 */
public interface GoodsDetailService extends IService<GoodsDetail> {

    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */
    GoodsVo detail(Integer goodsId);
}
