package com.MakeitFlauntit.MIFI.entity;

public class UserProfilePic {
   private String proPic;

public String getUserProPic() {
	return proPic;
}
public void setUserProPic(String proPic) {
	this.proPic = proPic;
}
public UserProfilePic(String proPic) {
	super();
	this.proPic = proPic;
}
public UserProfilePic() {
	
}

@Override
public String toString() {
	return "UserProfilePic [UserProPic=" + proPic + "]";
}
   
   
}
