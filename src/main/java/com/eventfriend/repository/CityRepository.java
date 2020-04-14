package com.eventfriend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eventfriend.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query( value = "Select u FROM City u WHERE u.name=:pName AND u.country=:pCountry")
	public City findByNameAndCountry(@Param("pName") String name, @Param("pCountry") String country);
	
	@Query(value = "Select u from City u where u.name LIKE CONCAT(:pName,'%') AND u.country=:pCountry")
	public Collection<City> findAllByNameAndCountry(@Param("pName") String name, @Param("pCountry") String country);
	
}
