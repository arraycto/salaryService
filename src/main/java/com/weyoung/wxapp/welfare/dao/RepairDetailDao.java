package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.RepairDetail;
import com.weyoung.wxapp.welfare.vo.RepairVo;
import org.springframework.stereotype.Repository;

/**
 * @author li
 * @date 2019-12-23
 */
@Repository
public interface RepairDetailDao extends MyMapper<RepairDetail> {

    /**
     * 师傅查询订单详情
     * @param repairId
     * @return
     */
    RepairDetail selectByRepairId(Integer repairId);
}