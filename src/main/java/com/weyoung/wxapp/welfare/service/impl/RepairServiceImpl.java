package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.domain.UploadFileResponse;
import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.RepairDao;
import com.weyoung.wxapp.welfare.dao.UserDao;
import com.weyoung.wxapp.welfare.domain.Repair;
import com.weyoung.wxapp.welfare.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li
 * @date 2019-12-5
 */
@Service
public class RepairServiceImpl extends BaseService<Repair> implements RepairService {
    @Autowired
    RepairDao repairDao;
    @Autowired
    UserDao userDao;
    @Override
    public int repair(Repair repair){
        return repairDao.insertSelective(repair);
    }


}
