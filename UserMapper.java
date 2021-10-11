package project2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setUsername(rs.getString("Username"));
		u.setPassword(rs.getString("Password"));
		u.setEmail(rs.getString("Email"));
		u.setFName(rs.getString("FirstName"));
		u.setLName(rs.getString("LastName"));
		u.setPhoneNum(rs.getString("PhoneNumber"));
		return u;
	}

}
