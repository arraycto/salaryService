package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.CategoryDao;
import com.weyoung.wxapp.welfare.dao.GoodsDao;
import com.weyoung.wxapp.welfare.domain.Category;
import com.weyoung.wxapp.welfare.domain.Goods;
import com.weyoung.wxapp.welfare.service.GoodsService;
import com.weyoung.wxapp.welfare.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @date 2019-11-19
 */
@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Category> getCategory(){
        return categoryDao.getCategory();
    }

    @Override
    public List<Goods> goodsList(Integer categoryId){
        return goodsDao.goodsList(categoryId);
    }
    @Override
    public GoodsVo seeGoods(Integer goodsId){
        return goodsDao.seeGoods(goodsId);
    }
    @Override
    public List<Goods> search(String goodsName){
//        if (goodsName == null || goodsName == ""){
//            goodsName = "111111111111111111111111111111111111111111111";
//        }
        return goodsDao.search(goodsName);
    }
}
