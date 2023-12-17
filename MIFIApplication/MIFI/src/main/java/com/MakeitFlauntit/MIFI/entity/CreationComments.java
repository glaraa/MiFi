package com.MakeitFlauntit.MIFI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class CreationComments {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int commId;
	  @Column(name="comProPic")
	  private String comProPic;
	  @Column(name="comFirstName")
	  private String comFirstName;
	  @Column(name="comLastName")
	  private String comLastName;
	  @Column(name="comUserName")
	  private String comUserName;
	  @Column(name="creationId")
	  private int creationId;
	  @Column(name="comment")
	  private String comment;

	  
	  
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getComProPic() {
		return comProPic;
	}

	public void setComProPic(String comProPic) {
		this.comProPic = comProPic;
	}
	public String getComFirstName() {
		return comFirstName;
	}

	public void setComFirstName(String comFirstName) {
		this.comFirstName = comFirstName;
	}

	public String getComLastName() {
		return comLastName;
	}

	public void setComLastName(String comLastName) {
		this.comLastName = comLastName;
	}

	public String getComUserName() {
		return comUserName;
	}

	public void setComUserName(String comUserName) {
		this.comUserName = comUserName;
	}

	public int getCreationId() {
		return creationId;
	}

	public void setCreationId(int creationId) {
		this.creationId = creationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	

	public CreationComments(int commId, String comProPic, String comFirstName, String comLastName, String comUserName,
			int creationId, String comment) {
		super();
		this.commId = commId;
		this.comProPic = comProPic;
		this.comFirstName = comFirstName;
		this.comLastName = comLastName;
		this.comUserName = comUserName;
		this.creationId = creationId;
		this.comment = comment;
	}
	
	
	
	@Override
	public String toString() {
		return "CreationComments [commId=" + commId + ", comProPic=" + comProPic + ", comFirstName=" + comFirstName
				+ ", comLastName=" + comLastName + ", comUserName=" + comUserName + ", creationId=" + creationId
				+ ", comment=" + comment + "]";
	}
	public CreationComments() {
		// TODO Auto-generated constructor stub
	}
	  
	  
}
