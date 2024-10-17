package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Teacher;
import com.wileyedge.fullstackschool.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        return teacherServiceImpl.getAllTeachers();

        //YOUR CODE ENDS HERE
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        //YOUR CODE STARTS HERE

        try {
            return teacherServiceImpl.getTeacherById(id);
        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        //YOUR CODE STARTS HERE

        return teacherServiceImpl.addNewTeacher(teacher);

        //YOUR CODE ENDS HERE
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        //YOUR CODE STARTS HERE

        try {
            teacherServiceImpl.updateTeacherData(id, teacher);
            return teacher;
        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        //YOUR CODE STARTS HERE

        try {
            teacherServiceImpl.deleteTeacherById(id);
        } catch (Exception e) {
            throw new RuntimeException("Id not in database");
        }

        //YOUR CODE ENDS HERE
    }
}
