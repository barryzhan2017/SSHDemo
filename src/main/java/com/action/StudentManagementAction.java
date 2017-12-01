package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.Student;
import com.service.StudentManagementService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.*;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */

@ParentPackage("json-default")
@Namespace("/students")
public class StudentManagementAction {
    private Map<String, Object> dataMap;
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
        this.dataMap = new HashMap<>();
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

    @Action(value = "add", results = {@Result(type = "json", params = {"root", "dataMap"})})
    public String addStudentToDormitory() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        String studentIdString = (ServletActionContext.getRequest().getParameter("studentIds"));
        Integer roomId = Integer.valueOf(ServletActionContext.getRequest().getParameter("roomId"));
        String bedIdString = (ServletActionContext.getRequest().getParameter("bedIds"));

        // get ids apart
        String[] studentIdRaw = studentIdString.split(",");
        List<Integer> studentIds = new ArrayList<>();
        String[] bedIdRaw = bedIdString.split(",");
        List<Integer> bedIds = new ArrayList<>();
        for (String s: studentIdRaw) {
            studentIds.add(Integer.valueOf(s));
        }
        for (String s: bedIdRaw) {
            bedIds.add(Integer.valueOf(s));
        }
        if (studentIds.size() != bedIds.size()) {
            dataMap.put("status", "fail");
            dataMap.put("code", "203");
            return "success";
        }

        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String) session.get("type");
        if (id == null || type == null) {
            dataMap.put("status", "fail");
            dataMap.put("code", "203");
            return "success";
        }

        for (int i = 0; i < studentIds.size(); ++i) {
            if (!studentManagementService.addStudentToDormitory(studentIds.get(i), roomId, bedIds.get(i), id)) {
                System.out.println("Add to dorm fails at " + i);
                System.out.println("Bed Ids: " + bedIds);
                System.out.println("Room Id: " + roomId);
                System.out.println("Student Ids: " + studentIds);
                dataMap.put("status", "fail");
                dataMap.put("code", "203");
                return "success";
            }
        }

        dataMap.put("status", "success");
        dataMap.put("code", "200");
        return "success";
    }

    @Action(value = "remove", results = {@Result(type = "json", params = {"root", "dataMap"})})
    public String removeStudentFromDormitory() throws Exception {
        this.dataMap = new HashMap<>();
        String studentIdString = (ServletActionContext.getRequest().getParameter("studentId"));
        String[] studentIdRaw = studentIdString.split(",");
        List<Integer> studentIds = new ArrayList<>();
        for (String s: studentIdRaw) {
            studentIds.add(Integer.valueOf(s));
        }

        String roomIdString = (ServletActionContext.getRequest().getParameter("roomId"));
        String[] roomIdRaw = roomIdString.split(",");
        List<Integer> roomIds = new ArrayList<>();
        for (String s: roomIdRaw) {
            roomIds.add(Integer.valueOf(s));
        }

        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String) session.get("type");
        if (id == null || type == null) {
            dataMap.put("status", "fail");
            dataMap.put("code", "203");
            return "success";
        }

        for (int i = 0; i < studentIds.size(); ++i) {
            if (!studentManagementService.removeStudentFromDormitory(studentIds.get(i), roomIds.get(i), id)) {
                System.out.println("Remove fails at " + i);
                System.out.println("Room Ids: " + roomIds);
                System.out.println("Student Ids: " + studentIds);
                dataMap.put("status", "fail");
                dataMap.put("code", "203");
                return "success";
            }
        }

        dataMap.put("status", "success");
        dataMap.put("code", "200");
        return "success";
    }

    @Action(value = "leader", results = {@Result(type = "json", params = {"root", "dataMap"})})
    public String appointRoomLeader() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        Integer studentId = Integer.valueOf(ServletActionContext.getRequest().getParameter("studentId"));
        Integer roomId = Integer.valueOf(ServletActionContext.getRequest().getParameter("roomId"));
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String) session.get("type");
        if (id != null && type != null && studentManagementService.appointRoomLeader(studentId, roomId, id)) {
            dataMap.put("status", "success");
            dataMap.put("code", "200");
        } else {
            dataMap.put("status", "fail");
            dataMap.put("code", "203");
        }
        return "success";
    }

    //display all students info for specific instructor or dormitory staff
    @Action(value = "display", results = {@Result(type = "json", params = {"root", "dataMap"})})
    public String display() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        List<Student> students;
//        Map session = ActionContext.getContext().getSession();
//        Integer id = (Integer) session.get("token");
//        String type = (String )session.get("type");
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String) session.get("type");
        if (id != null & type != null) {
            dataMap.put("code", "200");
            if (type.equals("instructor")) {
                students = studentManagementService.getAllStudentsByInstructorId(id);
            } else {
                students = studentManagementService.getAllStudentsByDormitoryStaffId(id);
            }
            ArrayList<Map<String, Object>> studentList = new ArrayList<Map<String, Object>>();
            for (Student student : students) {
                Map<String, Object> studentMap = new HashMap<String, Object>();
                studentMap.put("id", student.getId());
                studentMap.put("name", student.getName());
                studentMap.put("major", student.getMajor());
                studentMap.put("photoURL", student.getPhotoURL());
                studentMap.put("grade", student.getGrade());
                studentMap.put("phoneNumber", student.getPhoneNumber());
                studentMap.put("college", student.getCollege());
                studentMap.put("gender", student.getGender());
                if (student.getRoom() != null) {
                    studentMap.put("roomId", student.getRoom().getId());
                    studentMap.put("roomName", student.getRoom().getRoomName());
                }
                if (student.getBedId() != null) {
                    studentMap.put("bed", student.getBedId());
                }
                studentMap.put("classNumber", student.getId());
                studentMap.put("isRoomLeader", student.getRoomLeader());
                studentMap.put("dormitoryStaffId", student.getDormitoryStaff().getId());
                studentMap.put("InstructorId", student.getInstructor().getId());
                studentList.add(studentMap);
            }
            dataMap.put("students", studentList);
        } else {
            dataMap.put("code", "203");//no-authorized
        }
        return "success";
    }

    @Action(value = "room", results = {@Result(type = "json", params = {"root", "dataMap"})})
    public String getRooms() throws Exception {
        this.dataMap = new HashMap<String, Object>();
        Map session = ActionContext.getContext().getSession();
        Integer id = (Integer) session.get("id");
        String type = (String) session.get("type");
        if (id == null || type == null) {
            dataMap.put("status", "fail");
            dataMap.put("code", "203");
            return "success";
        }

        dataMap.put("rooms", studentManagementService.getAllRooms());
        return "success";
    }

}
