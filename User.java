package project2;

public class User {
	User() {
		
	}
	
	private int ID; //non-mutable value
	private String username;
	private String password;
	private String email;
	private String fname;
	private String lname;
	private String phone_num;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFName() {
		return fname;
	}

	public void setFName(String fname) {
		this.fname = fname;
	}

	public String getLName() {
		return lname;
	}

	public void setLName(String lname) {
		this.lname = lname;
	}

	public String getPhoneNum() {
		return phone_num;
	}

	public void setPhoneNum(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getID() {
		return ID;
	}
	
	
}
