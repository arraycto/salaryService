package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.domain.UploadFileResponse;
import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.Repair;

import java.util.List;

/**
 * @author li
 * @date 2019-12-5
 * */
public interface RepairService extends IService<Repair> {
    /**
     * 用户预约维修
     * @param repair
     * @return
     */
    int repair(Repair repair);
}
