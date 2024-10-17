package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.CourseDao;
import com.wileyedge.fullstackschool.dao.CourseDaoImpl;
import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.model.Course;
import com.wileyedge.fullstackschool.model.Student;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

        } catch (DataAccessException e) {
            Student student = studentDao.findStudentById(id);
            student.setStudentFirstName("Student Not Found");
            student.setStudentLastName("Student Not Found");
            return student;
        }

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        if (student.getStudentFirstName().isEmpty() || student.getStudentLastName().isEmpty()) {
            student.setStudentFirstName("First Name blank, student NOT added");
            student.setStudentLastName("Last Name blank, student NOT added");
            return student;
        }

        return studentDao.createNewStudent(student);

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE

        if (student.getStudentId() == id) {
            studentDao.updateStudent(student);

        } else {
            student.setStudentFirstName("IDs do not match, student not updated");
            student.setStudentLastName("IDs do not match, student not updated");
        }

        return student;

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE

        studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        Student student = studentDao.findStudentById(studentId);
        if (student.getStudentFirstName().equals("Student Not Found")){
            System.out.println("Student not found");
        } else {
            studentDao.deleteStudentFromCourse(studentId, courseId);
            studentDao.deleteStudent(studentId);
            System.out.println("Student: " + studentId + " deleted from course: " + courseId);
        }

        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE


        studentDao.addStudentToCourse(studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}