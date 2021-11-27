package application;

import java.time.LocalDate;

public class Manager {
	
	private String fullName;
	private String userName;
	private String phone;
	private LocalDate DoB;
	
	
	public Manager(String fullName, String userName, String phone, LocalDate doB) {
		
		this.fullName = fullName;
		this.userName = userName;
		this.phone = phone;
		this.DoB = doB;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDoB() {
		return DoB;
	}
	public void setDoB(LocalDate doB) {
		DoB = doB;
	}
	
}
