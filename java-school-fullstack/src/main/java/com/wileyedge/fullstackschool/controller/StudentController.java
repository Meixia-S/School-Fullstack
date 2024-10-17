package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Student;
import com.wileyedge.fullstackschool.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        return studentServiceImpl.getAllStudents();

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        //YOUR CODE STARTS HERE

        studentServiceImpl.addNewStudent(student);
        return student;

        //YOUR CODE ENDS HERE
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        //YOUR CODE STARTS HERE

        try {
            return studentServiceImpl.getStudentById(id);
        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        //YOUR CODE STARTS HERE

        try {
            return studentServiceImpl.updateStudentData(id, student);

        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        //YOUR CODE STARTS HERE

        try {
            studentServiceImpl.deleteStudentById(id);
        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public void deleteStudentFromCourse(@PathVariable int studentId, @PathVariable int courseId) {
        //YOUR CODE STARTS HERE

        try {
            studentServiceImpl.deleteStudentFromCourse(studentId, courseId);
        } catch (Exception e) {
            throw new RuntimeException("StudentId or CourseId not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/{studentId}/{courseId}")
    public void addStudentToCourse(@PathVariable int studentId, @PathVariable int courseId) {
        //YOUR CODE STARTS HERE

        try {
            studentServiceImpl.addStudentToCourse(studentId, courseId);
        } catch (Exception e) {
            throw new RuntimeException("StudentId or CourseId not in database");
        }

        //YOUR CODE ENDS HERE
    }
}
