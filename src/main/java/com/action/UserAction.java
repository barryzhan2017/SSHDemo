package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.service.StudentManagementService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanzhicheng on 11/27/2017.
 */
@ParentPackage("json-default")
@Namespace("/user")
public class UserAction {
    private Map<String,Object> dataMap;
    UserService userService;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Action(value = "authorize", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String addStudentToDormitory() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        String  account = ServletActionContext.getRequest().getParameter("account");
        String  password = ServletActionContext.getRequest().getParameter("password");
        String type = ServletActionContext.getRequest().getParameter("type");
        if (userService.authorize(account,password,type)) {
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
