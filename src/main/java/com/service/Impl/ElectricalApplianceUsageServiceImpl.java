package com.service.Impl;

import com.dao.ElectricalApplianceUsageDao;
import com.dao.RoomDao;
import com.pojo.ElectricalApplianceUsage;
import com.service.ElectricalApplianceUsageService;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
public class ElectricalApplianceUsageServiceImpl implements ElectricalApplianceUsageService {

    ElectricalApplianceUsageDao electricalApplianceUsageDao;
    RoomDao roomDao;
    public ElectricalApplianceUsageDao getElectricalApplianceUsageDao() {
        return electricalApplianceUsageDao;
    }

    public void setElectricalApplianceUsageDao(ElectricalApplianceUsageDao electricalApplianceUsageDao) {
        this.electricalApplianceUsageDao = electricalApplianceUsageDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id) {
        return electricalApplianceUsageDao.getAllElectricalApplianceUsage(id);
    }
}
