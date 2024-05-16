package io.swagger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.swagger.model.User;

@Repository
public class UserDao {

	private final JdbcTemplate jdbcTemplate;

	public UserDao(@Autowired JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertData(int id, String name) {
		String sql = "INSERT INTO User (id,name) VALUES (?,?)";
		jdbcTemplate.update(sql, id, name);
	}

	public List<User> getAllData() {
		String sql = "SELECT * FROM User";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	public static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new User();
		}
	}
}