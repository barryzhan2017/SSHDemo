package com.service;

import com.pojo.ElectricalApplianceUsage;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
public interface ElectricalApplianceUsageService {

    List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id);
    boolean update(String newSituation, Integer studentId);
}
