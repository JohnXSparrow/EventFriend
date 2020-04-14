package com.eventfriend.model;

import java.time.LocalDate;

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
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate date_time;

	@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Business business;

	@OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
	private Premium premium;

}
