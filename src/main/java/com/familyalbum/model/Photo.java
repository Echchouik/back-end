package com.familyalbum.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Photo {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long photoId;
	private String photoName;
	private String title;
	private String description;
	private String imageName;
	
	@CreationTimestamp
	private Date created;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	private int likes;
	
	
	@OneToMany(mappedBy = "photo", fetch = FetchType.EAGER)
	private List<Comment> commentList;


	public Long getPhotoId() {
		return photoId;
	}


	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}


	public String getPhotoName() {
		return photoName;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public List<Comment> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
}
