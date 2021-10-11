package project2;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;


public interface DAO_Interface {
	
	//General
	public void setDataSource(DataSource ds);
	
	//User
	public void addUser(String un, String pw, String em, String fn, String ln, String ph); //insert
	public void updateUsername(String un, String new_un);
	public void updatePassword(String un, String pw);
	public void updateEmail(String un, String em);
	public void updatePhone(String un, String ph);
	public void removeUser(String un);
	public User getUser(String un);
	public List<User> getAllUsers();
	
	//Transactions
	public void logTRX(String type, double amt, String cmt, Date d, String stat, String ori, String dest); //create
	public void updateStatus(int id, String stat);
	public Transaction getTRX(int id);
	public List<Transaction> getMyTRX(String un);
	public List<Transaction> getAllTRX();
	
	//Account
	
	public void openAccount(String un, double bal); //insert
	public void updateBalance(String un, double bal);
	public void closeAccount(int id); //delete by Account ID
	public void closeAccounts(String un); //delete accounts from specific user
	public Account getAccount(int id);
	public List<Account> getMyAccounts(String un);
	public List<Account> getAllAccounts();
	
}
