package com.MakeitFlauntit.MIFI.entity;

import javax.persistence.*;

@Entity
@Table(name = "userbuddies")
public class UserBuddies {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int buddyId;
@Column(name="userName")
private String userName;
@Column(name="buddyUserName")
private String buddyUserName;
public int getBuddyId() {
	return buddyId;
}
public void setBuddyId(int buddyId) {
	this.buddyId = buddyId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getBuddyUserName() {
	return buddyUserName;
}
public void setBuddyUserName(String buddyUserName) {
	this.buddyUserName = buddyUserName;
}

public UserBuddies() {
	
}

public UserBuddies(int buddyId, String userName, String buddyUserName) {
	super();
	this.buddyId = buddyId;
	this.userName = userName;
	this.buddyUserName = buddyUserName;
}
@Override
public String toString() {
	return "UserBuddies [buddyId=" + buddyId + ", userName=" + userName + ", buddyUserName=" + buddyUserName + "]";
}






	
}
