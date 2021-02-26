package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.common.util.BeanUtilsEx;
import com.weyoung.wxapp.welfare.dao.GoodsDao;
import com.weyoung.wxapp.welfare.dao.GoodsDetailDao;
import com.weyoung.wxapp.welfare.domain.Goods;
import com.weyoung.wxapp.welfare.domain.GoodsDetail;
import com.weyoung.wxapp.welfare.service.GoodsDetailService;
import com.weyoung.wxapp.welfare.service.GoodsService;
import com.weyoung.wxapp.welfare.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li
 * @date 2019-11-29
 */
@Service
public class GoodsDetailServiceImpl extends BaseService<GoodsDetail> implements GoodsDetailService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    public GoodsVo detail(Integer goodsId){
        return goodsDao.seeGoods(goodsId);
    }
}
