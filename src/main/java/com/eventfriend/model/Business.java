package com.eventfriend.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private LocalDateTime open_at;

	@Column(nullable = false)
	private LocalDateTime close_at;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private Address address;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private BusinessType businessType;

	@OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
	private Premium premium;

}
