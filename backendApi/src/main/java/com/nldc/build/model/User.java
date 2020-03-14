package com.nldc.build.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="phone")
	private String phone;

	@Lob
	@Column(name="profilePic")
	private Byte[] profilePic;
	
	@Column(name="identityNumber")
	private String identityNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="password")
	private String password;
	
	@Column(name="accessRole")
	private int accessRole;
	
	public User() {}
	

	public User(int id, String firstName, String lastName, String phone, int accessRole, Byte[] profilePic, String identityNumber, String email, String address, String password) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setProfilePic(profilePic);
		this.setIdentityNumber(identityNumber);
		this.setEmail(email);
		this.setAddress(address);
		this.setPassword(password);
		this.setAccessRole(accessRole);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Byte[] getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(Byte[] profilePic) {
		this.profilePic = profilePic;
	}


	public String getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAccessRole() {
		return accessRole;
	}


	public void setAccessRole(int accessRole) {
		this.accessRole = accessRole;
	}
	
	@Override
	public String toString() {
		return this.getEmail() + this.getFirstName() + this.getLastName();
	}
	
	
}
