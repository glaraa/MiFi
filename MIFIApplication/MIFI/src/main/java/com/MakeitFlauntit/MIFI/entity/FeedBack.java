package com.MakeitFlauntit.MIFI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="feedback")
public class FeedBack {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int fbId;
	  @Column(name="userName")
	  private String userName;
	  @Column(name="userfb")
	  private String userfb;
	public int getFbId() {
		return fbId;
	}
	public void setFbId(int fbId) {
		this.fbId = fbId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserfb() {
		return userfb;
	}
	public void setUserfb(String userfb) {
		this.userfb = userfb;
	}
	public FeedBack(int fbId, String userName, String userfb) {
		super();
		this.fbId = fbId;
		this.userName = userName;
		this.userfb = userfb;
	}
	public FeedBack() {
		
	}
	@Override
	public String toString() {
		return "FeedBack [fbId=" + fbId + ", userName=" + userName + ", userfb=" + userfb + "]";
	}
	  
	  
}
