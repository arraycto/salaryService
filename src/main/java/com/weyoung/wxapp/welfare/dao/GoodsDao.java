package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Goods;
import com.weyoung.wxapp.welfare.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao extends MyMapper<Goods> {
    /**
     * 根据类别获取商品
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
     * @param goodsName
     * @return
     */
    List<Goods> search(@Param("goodsName") String goodsName);
}