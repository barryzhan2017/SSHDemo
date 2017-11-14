package com.action;

import com.service.StudentManagementService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */

@ParentPackage("json-default")
@Namespace("/studentManagement")
public class StudentManagementAction {
    private Map<String,String> dataMap;
    StudentManagementService studentManagementService;
    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public StudentManagementService getStudentManagementService() {
        return studentManagementService;
    }

    public void setStudentManagementService(StudentManagementService studentManagementService) {
        this.studentManagementService = studentManagementService;
    }

    //Change dormitory is designed to change two given students to the other's dormitory
    @Action(value = "changeDormitory", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String changeDormitory() throws Exception {
        this.dataMap = new HashMap<String, String>();
        Integer studentId1 = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId1"));
        Integer studentId2 = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId2"));
        Boolean result = studentManagementService.changeDormitory(studentId1,studentId2);
        if (result) {
            dataMap.put("result", "success");
        }
        else {
            dataMap.put("result","fail");//if some student doesn't  exists
        }
        return "success";
    }

    @Action(value = "addStudentToDormitory", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String addStudentToDormitory() throws Exception {
        this.dataMap = new HashMap<String, String>();
        Integer studentId = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId"));
        Integer roomId = Integer.valueOf(ServletActionContext.getRequest().getParameter("roomId"));
        Integer bedId = Integer.valueOf(ServletActionContext.getRequest().getParameter("bedId"));
        return "success";
    }
}
