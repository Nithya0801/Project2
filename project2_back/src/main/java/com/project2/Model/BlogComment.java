package com.project2.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BlogComment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogComment")
	private int blogCommentId;
	
	private String blogCommentText;
	private String userName;
	private int blogId;
	private Date blogCommentDate;
	
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public String getBlogCommentText() {
		return blogCommentText;
	}
	public void setBlogCommentText(String blogCommentText) {
		this.blogCommentText = blogCommentText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public Date getBlogCommentDate() {
		return blogCommentDate;
	}
	public void setBlogCommentDate(Date blogCommentDate) {
		this.blogCommentDate = blogCommentDate;
	}
}
