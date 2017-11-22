package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.SanitaryStatus;
import com.pojo.Student;
import com.service.SanitaryStatusService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */

@ParentPackage("json-default")
@Namespace("/sanitary")
public class SanitaryStatusAction {
    private Map<String,Object> dataMap;
    SanitaryStatusService sanitaryStatusService;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public SanitaryStatusService getSanitaryStatusService() {
        return sanitaryStatusService;
    }

    public void setSanitaryStatusService(SanitaryStatusService sanitaryStatusService) {
        this.sanitaryStatusService = sanitaryStatusService;
    }

    //display all room sanitary statuses for specific instructor
    @Action(value = "display", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String display() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        List<Student> students;
        Map session = ActionContext.getContext().getSession();
//        Integer id = (Integer) session.get("token");
//        String type = (String )session.get("type");
        Integer id = 1;
        String type = "instructor";
        if (type.equals("instructor")&&id!=null) {
            dataMap.put("code","200");
            List<SanitaryStatus> sanitaryStatuses = sanitaryStatusService.getAllSanitaryStatus(id);
            ArrayList<Map<String,Object>> sanitaryStatusList = new ArrayList<Map<String, Object>>();
            ArrayList<Integer> countedRoomId = new ArrayList<Integer>(); //record counted roomId
               for (SanitaryStatus sanitaryStatus:sanitaryStatuses) {
                    if (!countedRoomId.contains(sanitaryStatus.getRoom().getId())){
                        Map<String,Object> sanitaryStatusMap = new HashMap<String, Object>();
                        Integer roomId = sanitaryStatus.getRoom().getId();
                        sanitaryStatusMap.put("roomId",roomId);
                        sanitaryStatusMap.put("roomNum",sanitaryStatus.getRoom().getRoomId());
                        ArrayList<Map<String, Object>> roomInfo = new ArrayList<Map<String, Object>>();
                        for (SanitaryStatus innerSanitaryStatus:sanitaryStatuses) {
                            if (innerSanitaryStatus.getRoom().getId()==roomId) {//find the room with same id
                                Map<String,Object> innerSanitaryStatusMap = new HashMap<String, Object>();
                                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                innerSanitaryStatusMap.put("date",sdf.format(innerSanitaryStatus.getDate()));
                                innerSanitaryStatusMap.put("score",innerSanitaryStatus.getScore());
                                roomInfo.add(innerSanitaryStatusMap);
                            }
                        }
                        sanitaryStatusMap.put("statuses",roomInfo);
                        countedRoomId.add(roomId);
                        sanitaryStatusList.add(sanitaryStatusMap);
                    }
            }
            dataMap.put("sanitaryStatuses",sanitaryStatusList);
        }
        else {
            dataMap.put("code","203");//no-authorized
        }
        return "success";
    }

}