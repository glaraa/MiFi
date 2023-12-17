package com.MakeitFlauntit.MIFI.entity;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "usercreations")
public class UserCreations {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int srNo;
	@Column(name="creation")
	private String creation;
	@Column(name="userName")
	private String userName;
	@Column(name="date")
	private LocalDate creationDate;
	@Column(name="caption")
	private String caption;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="proPic")
	private String proPic;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
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
	public String getProPic() {
		return proPic;
	}
	public void setProPic(String proPic) {
		this.proPic = proPic;
	}
	@Override
	public String toString() {
		return "UserCreations [srNo=" + srNo + ", creation=" + creation + ", userName=" + userName + ", creationDate="
				+ creationDate + ", caption=" + caption + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", proPic=" + proPic + "]";
	}
	public UserCreations(int srNo, String creation, String userName, LocalDate creationDate, String caption,
			String firstName, String lastName, String proPic) {
		super();
		this.srNo = srNo;
		this.creation = creation;
		this.userName = userName;
		this.creationDate = creationDate;
		this.caption = caption;
		this.firstName = firstName;
		this.lastName = lastName;
		this.proPic = proPic;
	}
	public UserCreations() {
		// TODO Auto-generated constructor stub
	}

	
	
	
}