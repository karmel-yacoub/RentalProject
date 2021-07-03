package com.codingdojo.rentproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class Apartment {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String buildingName;
	@NotNull
	private String address;
	@NotNull
	private Double price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;
	@NotNull
	private int bedroomnum;
	@NotNull
	private int bathroomnum;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "user_app", 
	        joinColumns = @JoinColumn(name = "apartment_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private List<User> users;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "user_app_ratings", 
	        joinColumns = @JoinColumn(name = "apartment_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private List<User> ratings;
	private List<Integer> rating;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getBedroomnum() {
		return bedroomnum;
	}

	public void setBedroomnum(int bedroomnum) {
		this.bedroomnum = bedroomnum;
	}

	public int getBathroomnum() {
		return bathroomnum;
	}

	public void setBathroomnum(int bathroomnum) {
		this.bathroomnum = bathroomnum;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getRatings() {
		return ratings;
	}

	public void setRatings(List<User> ratings) {
		this.ratings = ratings;
	}

	public List<Integer> getRating() {
		return rating;
	}

	public void setRating(List<Integer> rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
