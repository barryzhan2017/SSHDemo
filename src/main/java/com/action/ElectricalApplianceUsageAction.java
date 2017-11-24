package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.ElectricalApplianceUsage;
import com.pojo.Student;
import com.service.ElectricalApplianceUsageService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
@ParentPackage("json-default")
@Namespace("/electrical-appliance")
public class ElectricalApplianceUsageAction {
    private Map<String,Object> dataMap;
    ElectricalApplianceUsageService electricalApplianceUsageService;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public ElectricalApplianceUsageService getElectricalApplianceUsageService() {
        return electricalApplianceUsageService;
    }

    public void setElectricalApplianceUsageService(ElectricalApplianceUsageService electricalApplianceUsageService) {
        this.electricalApplianceUsageService = electricalApplianceUsageService;
    }

    //display all room sanitary statuses for specific instructor
    @Action(value = "display", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String display() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        List<Student> students;
        if (authorize()) {
            dataMap.put("code","200");
            //(Integer)(ActionContext.getContext().getSession().get("token"))
            List<ElectricalApplianceUsage> electricalApplianceUsages = electricalApplianceUsageService.getAllElectricalApplianceUsage(1);
            ArrayList<Map<String,Object>> electricalApplianceUsagesList = new ArrayList<Map<String, Object>>();
            for (ElectricalApplianceUsage electricalApplianceUsage:electricalApplianceUsages) {
                Map<String,Object> electricalApplianceUsageMap = new HashMap<String, Object>();
                electricalApplianceUsageMap.put("roomId",electricalApplianceUsage.getRoom().getId());
                electricalApplianceUsageMap.put("roomName",electricalApplianceUsage.getRoom().getRoomName());
                electricalApplianceUsageMap.put("situation",electricalApplianceUsage.getSituation());
                electricalApplianceUsageMap.put("studentId",electricalApplianceUsage.getStudent().getId());
                electricalApplianceUsageMap.put("studentName",electricalApplianceUsage.getStudent().getName());
                electricalApplianceUsagesList.add(electricalApplianceUsageMap);

            }
            dataMap.put("electricalApplianceUsagesStatuses",electricalApplianceUsagesList);
        }
        else {
            dataMap.put("status","fail");
            dataMap.put("code","203");//no-authorized
        }
        return "success";
    }


    private boolean authorize() {
        Map session = ActionContext.getContext().getSession();
//        Integer id = (Integer) session.get("token");
//        String type = (String )session.get("type");
        Integer id = 1;
        String type = "instructor";
        return type.equals("instructor")&&id!=null;
    }

}
