package com.vishnu.model;

import java.util.Random;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	private int catergoryId;
	
	@Column
	private String categoryName;
	@Column
    private	String categoryDiscription;
	public int getCatergoryId() {
		return catergoryId;
	}
	public void setCatergoryId(int catergoryId) {
		
		this.catergoryId = catergoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	

}
