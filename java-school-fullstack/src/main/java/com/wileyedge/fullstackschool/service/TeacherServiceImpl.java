package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.TeacherDao;
import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    //YOUR CODE ENDS HERE

    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        return teacherDao.getAllTeachers();

        //YOUR CODE ENDS HERE
    }

    public Teacher getTeacherById(int id) {
        //YOUR CODE STARTS HERE

        return teacherDao.findTeacherById(id);

        //YOUR CODE ENDS HERE
    }

    public Teacher addNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE

        return teacherDao.createNewTeacher(teacher);

        //YOUR CODE ENDS HERE
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {
        //YOUR CODE STARTS HERE

        try {
            teacherDao.updateTeacher(teacher);
            return teacherDao.findTeacherById(id);

        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    public void deleteTeacherById(int id) {
        //YOUR CODE STARTS HERE

        try {
            teacherDao.deleteTeacher(id);

        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }
}