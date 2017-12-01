package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.ElectricalApplianceUsage;
import com.pojo.Student;
import com.service.ElectricalApplianceUsageService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.text.SimpleDateFormat;
import java.util.*;

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
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String )session.get("type");
        if (type!=null&&id!=null) {
            dataMap.put("code","200");
            //(Integer)(ActionContext.getContext().getSession().get("token"))
            List<ElectricalApplianceUsage> electricalApplianceUsages = electricalApplianceUsageService.getAllElectricalApplianceUsage(1);
            ArrayList<Map<String,Object>> electricalApplianceUsagesList = new ArrayList<Map<String, Object>>();
            for (ElectricalApplianceUsage electricalApplianceUsage:electricalApplianceUsages) {
                Map<String,Object> electricalApplianceUsageMap = new HashMap<String, Object>();
                electricalApplianceUsageMap.put("id",electricalApplianceUsage.getId());
                electricalApplianceUsageMap.put("roomId",electricalApplianceUsage.getRoom().getId());
                electricalApplianceUsageMap.put("roomName",electricalApplianceUsage.getRoom().getRoomName());
                electricalApplianceUsageMap.put("situation",electricalApplianceUsage.getSituation());
                electricalApplianceUsageMap.put("studentId",electricalApplianceUsage.getStudent().getId());
                electricalApplianceUsageMap.put("studentName",electricalApplianceUsage.getStudent().getName());
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                electricalApplianceUsageMap.put("date",sdf.format(electricalApplianceUsage.getDate()));
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
    @Action(value = "update", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String update() throws Exception {
        this.dataMap = new HashMap<String, Object>();

        Integer ElectricalApplianceUsageId = Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
        String newSituation = ServletActionContext.getRequest().getParameter("newSituation");
        System.out.println(newSituation);
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String )session.get("type");
        if (id!=null&&type!=null&&electricalApplianceUsageService.update(newSituation, ElectricalApplianceUsageId)) {
            dataMap.put("status","success");
            dataMap.put("code","200");
        }
        else {
            dataMap.put("status","fail");
            dataMap.put("code","203");
        }
        return "success";
    }
    @Action(value = "add", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String add() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        Integer studentId = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId"));
        String newSituation = ServletActionContext.getRequest().getParameter("newSituation");
        String dateString = ServletActionContext.getRequest().getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =  sdf.parse(dateString.toString());
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String )session.get("type");
        if (id!=null&&type!=null&&electricalApplianceUsageService.add(studentId,date,id,newSituation)) {
            dataMap.put("status","success");
            dataMap.put("code","200");
        }
        else {
            dataMap.put("status","fail");
            dataMap.put("code","203");
        }
        return "success";
    }


}
