package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.dao.mappers.StudentMapper;
import com.wileyedge.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Student createNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        final String INSERT_STUDENT = "INERT INTO student(firstName, lastName) VALUES(?, ?)";
        jdbcTemplate.update(INSERT_STUDENT,
                student.getStudentFirstName(),
                student.getStudentLastName());

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        student.setStudentId(newId);

        return student;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
        return jdbcTemplate.query(SELECT_ALL_STUDENTS, new StudentMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Student findStudentById(int id) {
        //YOUR CODE STARTS HERE

        final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(SELECT_STUDENT_BY_ID, new StudentMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateStudent(Student student) {
        //YOUR CODE STARTS HERE

        final String UPDATE_STUDENT = "UPDATE student SET firstName = ?, lastName = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_STUDENT,
                student.getStudentFirstName(),
                student.getStudentLastName(),
                student.getStudentId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudent(int id) {
        //YOUR CODE STARTS HERE

        final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(DELETE_STUDENT_BY_ID, id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        final String INSERT_STUDENT_TO_COURSE = "INSERT INTO course_student(student_id, course_id) " +
                                     "Values(?, ?)";
        jdbcTemplate.update(INSERT_STUDENT_TO_COURSE, studentId, courseId);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        final String DELETE_STUDENT_FROM_COURSE = "DELETE FROM course_student " +
                                                "WHERE student_id = ? AND course_id = ?";
        jdbcTemplate.update(DELETE_STUDENT_FROM_COURSE, studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}