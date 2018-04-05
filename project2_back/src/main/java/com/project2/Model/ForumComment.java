package com.project2.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ForumComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumComment")
	private int forumCommentId;
	
	private String forumCommentText;
	private String userName;
	private int forumId;
	private Date forumCommentDate;
	
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public String getForumCommentText() {
		return forumCommentText;
	}
	public void setForumCommentText(String forumCommentText) {
		this.forumCommentText = forumCommentText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public Date getForumCommentDate() {
		return forumCommentDate;
	}
	public void setForumCommentDate(Date forumCommentDate) {
		this.forumCommentDate = forumCommentDate;
	}

}
