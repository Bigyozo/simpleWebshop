package dut.myshop.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	String username;
	String password;
	String repassword;
	String gender;
	String email;
	String telephone;
	String introduce;
	String imageCode;
	Map<String,String> errors=new HashMap<String,String>();
	
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getUsername() {
		return username;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public boolean validate(String verifyCode) {
		boolean isOk=true;
		if(this.username==null||this.username.trim().equals("")) {		
			isOk=false;
			errors.put("username", "用户名不能为空");
		}
		else{
			if(!this.username.matches("^[A-Za-z0-9]{3,10}$")) {
				isOk=false;
				errors.put("username", "用户名必须是3-10位字母或数字");
			}
		}
		if(this.password==null||this.password.trim().equals("")) {		
			isOk=false;
			errors.put("password", "密码不能为空");
		}
		else{
			if(!this.password.matches("^[A-Za-z0-9]{3,10}$")) {
				isOk=false;
				errors.put("password", "密码必须是3-10位字母或数字");
			}
		}
		if(this.repassword==null||this.repassword.trim().equals("")) {		
			isOk=false;
			errors.put("repassword", "确认密码不能为空");
		}
		else{
			if(!this.repassword.equals(this.password)) {
				isOk=false;
				errors.put("repassword", "两次密码要一致");
			}
		}
		if(this.email==null||this.email.trim().equals("")) {		
			isOk=false;
			errors.put("email", "邮箱不能为空");
		}
		else{
			if(!this.email.matches("^\\w+@\\w+(\\.\\w+)+$")) {
				isOk=false;
				errors.put("email", "邮箱格式不正确");
			}
		}
		if(this.imageCode==null||this.imageCode.trim().equals("")) {		
			isOk=false;
			errors.put("imageCode", "验证码不能为空");
		}
		else{
			if(!this.imageCode.equalsIgnoreCase(verifyCode)) {
				isOk=false;
				errors.put("imageCode", "验证码错误");
			}
		}
		return isOk;
	}
}
