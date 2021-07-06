package com.codingdojo.rentproject.models;


import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String username;
	@Column(name = "verification_code", length = 64)
    private String verificationCode;    
	private boolean enabled;
	@Email(message = " • Email is in an invalid format. proper format: name@host.com")
	@Column(unique=true)
	private String email;
	@NotBlank(message = "• Password field must not be blank")
	@Size(min = 8, message = "• Password must be 5 characters or more")
	private String password;
	@Transient
	private String passwordConfirmation;
	@Size(min=9)
	private String phonenumber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;
	private String image;
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Apartment> hostedapartments;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "user_app", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "apartment_id")
	    )
	private List<Apartment> rentedapartments;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "user_app_ratings", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "apartment_id")
	    )
	private List<Apartment> ratedappartments;
	 @Transient
	    public String getPhotosImagePath() {
	        if (image == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + image;
	    }
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
		        name = "rates_app", 
		        joinColumns = @JoinColumn(name = "user_id"), 
		        inverseJoinColumns = @JoinColumn(name = "apartment_id")
		    )
		private List<Apartment> rated_apps;
	
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public List<Apartment> getHostedapartments() {
		return hostedapartments;
	}

	public void setHostedapartments(List<Apartment> hostedapartments) {
		this.hostedapartments = hostedapartments;
	}

	public List<Apartment> getRentedapartments() {
		return rentedapartments;
	}

	public void setRentedapartments(List<Apartment> rentedapartments) {
		this.rentedapartments = rentedapartments;
	}

	public List<Apartment> getRatedappartments() {
		return ratedappartments;
	}

	public void setRatedappartments(List<Apartment> ratedappartments) {
		this.ratedappartments = ratedappartments;
	}

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

	public User() {
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Apartment> getRated_apps() {
		return rated_apps;
	}

	public void setRated_apps(List<Apartment> rated_apps) {
		this.rated_apps = rated_apps;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}

