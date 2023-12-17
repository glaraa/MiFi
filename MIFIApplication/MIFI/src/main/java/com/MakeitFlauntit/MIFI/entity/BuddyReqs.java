package com.MakeitFlauntit.MIFI.entity;

import javax.persistence.*;

@Entity
@Table(name="buddyreqs")
public class BuddyReqs {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int reqId;
  @Column(name="reqUserName")
  private String reqUserName;
  @Column(name="addedUserName")
  private String addedUserName;
public int getReqId() {
	return reqId;
}
public void setReqId(int reqId) {
	this.reqId = reqId;
}
public String getReqUserName() {
	return reqUserName;
}
public void setReqUserName(String reqUserName) {
	this.reqUserName = reqUserName;
}
public String getAddedUserName() {
	return addedUserName;
}
public void setAddedUserName(String addedUserName) {
	this.addedUserName = addedUserName;
}
public BuddyReqs() {
	
}
public BuddyReqs(int reqId, String reqUserName, String addedUserName) {
	super();
	this.reqId = reqId;
	this.reqUserName = reqUserName;
	this.addedUserName = addedUserName;
}
@Override
public String toString() {
	return "BuddyReqs [reqId=" + reqId + ", reqUserName=" + reqUserName + ", addedUserName=" + addedUserName + "]";
}
  

  
  
}
