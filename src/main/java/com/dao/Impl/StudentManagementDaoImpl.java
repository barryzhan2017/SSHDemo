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


    @Override
    public Boolean searchStudentByRoom(Integer studentId, Integer roomId) {
            String hql1 = "from Student s  where  s.id=?";
            if (((List<Student>)getHibernateTemplate().find(hql1,studentId)).isEmpty()) {
                return false;
            }
            Student student = ((List<Student>)getHibernateTemplate().find(hql1,studentId)).get(0);
            //find if the student's room number is the same as the given roomId
            if (student.getRoom().getRoomId()!=roomId) {
                return  false;
            }
            return true;

    }

    @Override
    public Student searchStudentById(Integer studentId) {
        String hql1 = "from Student s  where  s.id=?";
        List<Student> students = (List<Student>)getHibernateTemplate().find(hql1,studentId);
        if (students.isEmpty()){
            return null;
        }
        return students.get(0);
    }

    @Override
    public void updateStudent(Student student) {
        getHibernateTemplate().update(student);
    }


}
