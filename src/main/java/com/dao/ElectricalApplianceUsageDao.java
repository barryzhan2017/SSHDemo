package com.dao;

import com.pojo.ElectricalApplianceUsage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
@Transactional
public interface ElectricalApplianceUsageDao {

    List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id);
}
