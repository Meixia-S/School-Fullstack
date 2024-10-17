package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.dao.mappers.StudentMapper;
import com.wileyedge.fullstackschool.dao.mappers.TeacherMapper;
import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE

        final String INSERT_TEACHER = "INERT INTO teacher(firstName, lastName, dept) VALUES(?, ?, ?)";
        jdbcTemplate.update(INSERT_TEACHER,
                teacher.getTeacherFName(),
                teacher.getTeacherFName(),
                teacher.getDept());

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        teacher.setTeacherId(newId);

        return teacher;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        final String SELECT_ALL_TEACHER = "SELECT * FROM teacher";
        return jdbcTemplate.query(SELECT_ALL_TEACHER, new TeacherMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Teacher findTeacherById(int id) {
        //YOUR CODE STARTS HERE

        final String SELECT_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id = ?";
        return jdbcTemplate.queryForObject(SELECT_TEACHER_BY_ID, new TeacherMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateTeacher(Teacher t) {
        //YOUR CODE STARTS HERE

        final String UPDATE_TEACHER = "UPDATE teacher SET firstName = ?, lastName = ?, dept = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_TEACHER,
                t.getTeacherFName(),
                t.getTeacherFName(),
                t.getDept(),
                t.getTeacherId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteTeacher(int id) {
        //YOUR CODE STARTS HERE

        final String DELETE_TEACHER_FROM_COURSE = "DELETE FROM course WHERE teacherId = ?";
        jdbcTemplate.update(DELETE_TEACHER_FROM_COURSE, id);

        final String DELETE_TEACHER_BY_ID = "DELETE FROM teacher WHERE id = ?";
        jdbcTemplate.update(DELETE_TEACHER_BY_ID, id);

        //YOUR CODE ENDS HERE
    }
}
