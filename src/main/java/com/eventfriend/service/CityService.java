package com.eventfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eventfriend.model.ReturnMessage;
import com.eventfriend.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;

	public Object getByCityAndCountry(String name, String country) {
		var city = cityRepository.findByNameAndCountry(name, country);
		return city != null ? ResponseEntity.ok(city) : ResponseEntity.badRequest().body(new ReturnMessage("600", "Cidade não encontrada."));
	}

	public Object listByNameAndCountry(String name, String country) {
		return ResponseEntity.ok(cityRepository.findAllByNameAndCountry(name, country));
	}

}
