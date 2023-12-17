package com.MakeitFlauntit.MIFI.entity;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
//@DynamicUpdate(true)
@Table(name = "allrecords")
public class AllRecords {
	@Id
	private String userName;
	@Column(name = "firstName")
    private String firstName;
	@Column(name = "lastName")
    private String lastName;
	@Column(name = "password")
   private String password;
	@Column(name = "category")
   private String category;
	@Column(name = "email")
   private String email;
	@Column(name = "gender")
   private String gender;
	@Column(name = "proPic")
	   private String userProPic;
	@Column(name = "about")
	   private String userAbout;
	@Column(name = "role")
	  private String role;
//	@OneToMany(mappedBy = "ar",fetch = FetchType.EAGER)
	//@JoinColumn(name="user_creations_join",referencedColumnName="userName")
//    private List<UserCreations> usercreations;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserProPic() {
		return userProPic;
	}
	public void setUserProPic(String userProPic) {
		this.userProPic = userProPic;
	}
	public String getUserAbout() {
		return userAbout;
	}
	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public List<UserCreations> getUsercreations() {
//		return usercreations;
//	}
//	public void setUsercreations(List<UserCreations> usercreations) {
//		this.usercreations = usercreations;
//	}
	public AllRecords() {
		
	}
	public AllRecords(String userName, String firstName, String lastName, String password, String category,
			String email, String gender, String userProPic, String userAbout, String role) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.category = category;
		this.email = email;
		this.gender = gender;
		this.userProPic = userProPic;
		this.userAbout = userAbout;
		this.role = role;
		//this.usercreations = usercreations;
	}
	@Override
	public String toString() {
		return "AllRecords [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", category=" + category + ", email=" + email + ", gender=" + gender
				+ ", userProPic=" + userProPic + ", userAbout=" + userAbout + ", role=" + role + "]";
	}
	
	
	
	

	}
	




   
   
