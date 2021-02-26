package com.weyoung.wxapp.welfare.vo;

import com.weyoung.wxapp.welfare.domain.Repair;
import com.weyoung.wxapp.welfare.domain.RepairDetail;

import java.io.Serializable;
import java.util.List;

/**
 * @author li
 * @date 2019-12-24
 */
public class RepairVo implements Serializable {
    private Repair repair;
    private RepairDetail repairDetail;

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public RepairDetail getRepairDetail() {
        return repairDetail;
    }

    public void setRepairDetail(RepairDetail repairDetail) {
        this.repairDetail = repairDetail;
    }
}
