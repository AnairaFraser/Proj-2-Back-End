package project2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account acc = new Account();
		acc.setID(rs.getInt("ACC_ID"));
		acc.setUsername(rs.getString("Username"));
		acc.setBalance(rs.getDouble("Balance"));
		return acc;
	}

}
