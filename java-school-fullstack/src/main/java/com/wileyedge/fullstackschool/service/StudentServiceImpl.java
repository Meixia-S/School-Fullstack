package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.model.Course;
import com.wileyedge.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //YOUR CODE ENDS HERE

    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        return studentDao.getAllStudents();

        //YOUR CODE ENDS HERE
    }

    public Student getStudentById(int id) {
        //YOUR CODE STARTS HERE

        try {
            return studentDao.findStudentById(id);

        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        return studentDao.createNewStudent(student);

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE

        try {
            studentDao.updateStudent(student);
            return studentDao.findStudentById(id);

        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE

        studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        studentDao.deleteStudentFromCourse(studentId, courseId);
        studentDao.deleteStudent(studentId);

        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        studentDao.addStudentToCourse(studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}