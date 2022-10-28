package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("password"));
            return user;
        }
    };

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void insert(User user) {
        this.jdbcTemplate.update("insert into user(id, name, password) values (?, ?, ?);",
                user.getId(), user.getName(), user.getPassword());
    }
    public User select(String id) {
        String sql = "Select * from user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    public void deleteById(String id) {
        this.jdbcTemplate.update("Delete * from user where id = ?;", id);
    }
    public void deleteAll() {
        this.jdbcTemplate.update("Delete from user");
    }
    public int getCount()  {
        return this.jdbcTemplate.queryForObject("select count(*) from user;", Integer.class);
    }
}
