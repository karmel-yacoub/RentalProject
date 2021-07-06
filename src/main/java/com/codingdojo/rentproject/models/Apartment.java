package com.codingdojo.rentproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
@Entity
@Table(name = "apartments")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String buildingName;
	@NotNull
	private String address;
	@NotNull
	private Double price;
	@NotNull
	private int bedroomnum;
	@NotNull
	private int bathroomnum;
	@NotNull
	private String area;
	private String image;
	
	 @Transient
	    public String getPhotosImagePath() {
	        if (image == null || id == null) return null;
	         
	        return "/user-photos/" + host.getId() + "/" + image;
	    }
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
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "rates_app", 
	        joinColumns = @JoinColumn(name = "apartment_id"), 
	        inverseJoinColumns = @JoinColumn(name = "rate_id")
	    )
	private List<Rate> rated_apps;
	
	

    private String state;

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



	public List<Rate> getRated_apps() {
		return rated_apps;
	}

	public void setRated_apps(List<Rate> rated_apps) {
		this.rated_apps = rated_apps;
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
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
