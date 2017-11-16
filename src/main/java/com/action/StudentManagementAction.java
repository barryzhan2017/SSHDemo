package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.Student;
import com.service.StudentManagementService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */

@ParentPackage("json-default")
@Namespace("/students")
public class StudentManagementAction {
    private Map<String,Object> dataMap;
    StudentManagementService studentManagementService;
    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
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
        this.dataMap = new HashMap<String, Object>();
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
        this.dataMap = new HashMap<String, Object>();
        Integer studentId = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId"));
        Integer buildingId = Integer.valueOf(ServletActionContext.getRequest().getParameter("buildingId"));
        Integer roomId = Integer.valueOf(ServletActionContext.getRequest().getParameter("roomId"));
        Integer bedId = Integer.valueOf(ServletActionContext.getRequest().getParameter("bedId"));
//        studentManagementService.addStudentToDormitory(studentId,buildingId,roomId,bedId);
        return "success";
    }

    //display all student info for specific instructor or dormitory staff
    @Action(value = "display", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String display() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        List<Student> students;
        Map session = ActionContext.getContext().getSession();
//        Integer id = (Integer) session.get("token");
//        String type = (String )session.get("type");
        Integer id = 1;
        String type = "instructor";
        if (id!=null&type!=null) {
            dataMap.put("code","200");
            if (type.equals("instructor")) {
                students = studentManagementService.getAllStudentsByInstructorId(id);
            }
            else {
                students = studentManagementService.getAllStudentsByDormitoryStaffId(id);
            }
            ArrayList<Map<String,Object>> studentList = new ArrayList<Map<String, Object>>();
            for (Student student:students) {
                Map<String,Object> studentMap = new HashMap<String, Object>();
                studentMap.put("id",student.getId());
                studentMap.put("name",student.getName());
                studentMap.put("major",student.getMajor());
                studentMap.put("photoURL",student.getPhotoURL());
                studentMap.put("grade",student.getGrade());
                studentMap.put("phoneNumber",student.getPhoneNumber());
                studentMap.put("college",student.getCollege());
                studentMap.put("gender",student.getGender());
                studentMap.put("roomId",student.getRoom().getId());
                studentMap.put("bed",student.getBedId());
                studentMap.put("classNumber",student.getId());
                studentMap.put("isRoomLeader",student.getRoomLeader());
                studentMap.put("dormitoryStaffId",student.getDormitoryStaff().getId());
                studentMap.put("InstructorId",student.getInstructor().getId());
                studentList.add(studentMap);
            }
            dataMap.put("students",studentList);
        }
        else {
            dataMap.put("code","203");//no-authorized
        }
        return "success";
    }

}
