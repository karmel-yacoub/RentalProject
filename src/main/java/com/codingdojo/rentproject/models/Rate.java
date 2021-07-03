package com.codingdojo.rentproject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "rates_app", 
	        joinColumns = @JoinColumn(name = "rate_id"), 
	        inverseJoinColumns = @JoinColumn(name = "apartment_id")
	    )
	private List<Apartment> rated_apps;
}
