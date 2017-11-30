package com.service;

import com.pojo.ElectricalApplianceUsage;

import java.util.Date;
import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
public interface ElectricalApplianceUsageService {

    List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id);
    boolean update(String newSituation, Integer id);
    boolean add(Integer studentId, Date date, Integer id, String newSituation);
}
