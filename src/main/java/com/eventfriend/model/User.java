package com.eventfriend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.eventfriend.enumeration.gender;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String first_name;

	@Column(nullable = false)
	private String last_name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private gender gender;

	@Column(nullable = false, unique = true)
	private String phone;
	
	@Column(nullable = false)
	private String code;

	@Column(nullable = true)
	private String photo;

	@Column(nullable = true, unique = true)
	private String email;

	@Column(nullable = false)
	private boolean active;
	
	@Column(nullable = false)
	private String role;

	@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private City city;

}
