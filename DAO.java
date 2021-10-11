package project2;

import java.sql.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;



public class DAO implements DAO_Interface {
	
	/* GENERAL */
	
	private DataSource ds;
	private JdbcTemplate template;

	public DataSource getDs() {
		return ds;
	}
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.template = new JdbcTemplate(ds);
	}
	
	
	
	/* USERS */
	
	@Override
	public void addUser(String un, String pw, String em, String fn, String ln, String ph) {
		String SQL = "INSERT INTO Users(Username, Password, Email, FirstName, LastName, PhoneNumber) VALUES(?,?,?,?,?,?)";
		template.update(SQL,un,pw,em,fn,ln,ph);

	}

	@Override
	public void updateUsername(String un, String new_un) {
		String SQL = "UPDATE Users SET Username = ? WHERE Username = ?";
		template.update(SQL,new_un,un);

	}

	@Override
	public void updatePassword(String un, String pw) {
		String SQL = "UPDATE Users SET Password = ? WHERE Username = ?";
		template.update(SQL,pw,un);

	}

	@Override
	public void updateEmail(String un, String em) {
		String SQL = "UPDATE Users SET Email = ? WHERE Username = ?";
		template.update(SQL,em,un);

	}

	@Override
	public void updatePhone(String un, String ph) {
		String SQL = "UPDATE Users SET Phone = ? WHERE Username = ?";
		template.update(SQL,ph,un);

	}

	@Override
	public void removeUser(String un) {
		String SQL = "DELETE FROM Users WHERE Username = ?";
		template.update(SQL,un);

	}
	
	@Override
	public User getUser(String un) {
		String SQL = "SELECT * FROM Users WHERE Username = ?";
		User u = template.queryForObject(SQL, new UserMapper(), un);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		String SQL = "SELECT * FROM Users WHERE Username = ?";
		List<User> L = template.query(SQL, new UserMapper());
		return L;
	}
	
	
	/* TRANSACTIONS */
	

	@Override
	public void logTRX(String type, double amt, String cmt, Date d, String stat, String ori, String dest) {
		String SQL = "";
		template.update(SQL);

	}
	
	@Override
	public void updateStatus(int id, String stat) {
		String SQL = "UPDATE Transactions SET Status = ? WHERE TRX_ID = ?";
		template.update(SQL,stat,id);
	}

	@Override
	public Transaction getTRX(int id) {
		String SQL = "SELECT * FROM Transactions WHERE TRX_ID = ?";
		Transaction trx = template.queryForObject(SQL, new TRX_Mapper(), id);
		return trx;
	}

	@Override
	public List<Transaction> getMyTRX(String un) {
		String SQL = "SELECT * FROM Transactions WHERE Origin = ? OR Destination = ?";
		List<Transaction> L = template.query(SQL, new TRX_Mapper(), un, un);
		return L;
	}

	@Override
	public List<Transaction> getAllTRX() {
		String SQL = "SELECT * FROM Transactions";
		List<Transaction> L = template.query(SQL, new TRX_Mapper());
		return L;
	}
	
	
	/* ACCOUNTS */
	
	

	@Override
	public void openAccount(String un, double bal) {
		String SQL = "INSERT INTO Account(Username, Balance) VALUES(?,?)";
		template.update(SQL,un,bal);
	}

	@Override
	public void updateBalance(String un, double bal) {
		String SQL = "UPDATE BALANCE SET Balance = ? WHERE Username = ?";
		template.update(SQL,bal,un);

	}

	@Override
	public void closeAccount(int id) {
		String SQL = "DELETE FROM Account WHERE ACC_ID = ?";
		template.update(SQL,id);

	}

	@Override
	public void closeAccounts(String un) {
		String SQL = "DELETE FROM Account WHERE Username = ?";
		template.update(SQL,un);

	}

	@Override
	public Account getAccount(int id) {
		String SQL = "SELECT * FROM Account WHERE ACC_ID = ?";
		Account acc = template.queryForObject(SQL, new AccountMapper(), id);
		return acc;
	}

	@Override
	public List<Account> getMyAccounts(String un) {
		String SQL = "SELECT * FROM Account WHERE Username = ?";
		List<Account> L = template.query(SQL, new AccountMapper(), un);
		return L;
	}

	@Override
	public List<Account> getAllAccounts() {
		String SQL = "SELECT * FROM Account";
		List<Account> L = template.query(SQL, new AccountMapper());
		return L;
	}

}
