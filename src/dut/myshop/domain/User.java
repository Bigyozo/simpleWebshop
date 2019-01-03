package dut.myshop.domain;



public class User {
	int id;
	String username;
	String password;
	String gender;
	String email;
	String telephone;
	String introduce;
	String activeCode;
	int state;
	String role;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public int getState() {
		return state;
	}
	public String getRole() {
		return role;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
