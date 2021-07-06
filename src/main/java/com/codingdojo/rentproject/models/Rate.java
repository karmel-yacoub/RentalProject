package com.codingdojo.rentproject.models;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "rates")
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Integer rate;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="apartment_id")
	    private Apartment apartment;
	    


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}



	
}
