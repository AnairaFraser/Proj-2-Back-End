package project2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TRX_Mapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction trx = new Transaction();
		trx.setID(rs.getInt("TRX_ID"));
		trx.setType(rs.getString("Type"));
		trx.setAmount(rs.getDouble("Amount"));
		trx.setComment(rs.getString("Comment"));
		trx.setDate(rs.getDate("Date"));
		trx.setOrigin(rs.getString("Origin"));
		trx.setDestination(rs.getString("Destination"));
		return trx;
	}

}
