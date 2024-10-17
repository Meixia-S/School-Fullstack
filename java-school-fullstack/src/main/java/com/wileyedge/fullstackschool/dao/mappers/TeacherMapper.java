package com.wileyedge.fullstackschool.dao.mappers;

import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        Teacher teacher = new Teacher();

        teacher.setTeacherId(rs.getInt("id"));
        teacher.setTeacherFName(rs.getString("firstName"));
        teacher.setTeacherLName(rs.getString("lastName"));

        return teacher;

        //YOUR CODE ENDS HERE
    }
}
