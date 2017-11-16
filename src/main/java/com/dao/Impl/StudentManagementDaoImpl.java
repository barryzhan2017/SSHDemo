package com.dao.Impl;

import com.dao.StudentManagementDao;
import com.pojo.Room;
import com.pojo.Student;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */

@Transactional
public class StudentManagementDaoImpl extends  HibernateDaoSupport implements StudentManagementDao {


//    @Override
//    public Boolean searchStudentByRoom(Integer studentId, String roomId) {
//            String hql1 = "from Student student  where  student.id=?";
//            if (((List<Student>)getHibernateTemplate().find(hql1,studentId)).isEmpty()) {
//                return false;
//            }
//            Student student = ((List<Student>)getHibernateTemplate().find(hql1,studentId)).get(0);
//            //find if the student's room number is the same as the given roomId
//            if (!student.getRoom().getRoomId().equals(roomId)) {
//                return  false;
//            }
//            return true;
//
//    }

    @Override
    public Student searchStudentById(Integer studentId) {
        String hql = "from Student student  where  student.id=?";
        List<Student> students = (List<Student>)getHibernateTemplate().find(hql,studentId);
        if (students.isEmpty()){
            return null;
        }
        return students.get(0);
    }

    @Override
    public void updateStudent(Student student) {
        getHibernateTemplate().update(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public List<Student> getAllStudentsByInstructorId(Integer id) {
        String hql = "from  Student student where  student.instructor.id=?";
        List<Student> students = (List<Student>)getHibernateTemplate().find(hql,id);
        if (students.isEmpty()){
            return null;
        }
        return students;
    }

    @Override
    public List<Student> getAllStudentsByDormitoryStaffId(Integer id) {
        String hql = "from  Student student where  student.dormitoryStaff.id=?";
        List<Student> students = (List<Student>)getHibernateTemplate().find(hql,id);
        if (students.isEmpty()){
            return null;
        }
        return students;
    }


}
