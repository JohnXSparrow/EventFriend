package com.eventfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventfriend.model.City;
import com.eventfriend.service.CityService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@ApiOperation(value = "Get a city by params", response = City.class)
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	Object getCity(@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "country", required = true) String country) {
		return cityService.getByCityAndCountry(city, country);
	}

	@ApiOperation(value = "List city by compare params", response = City.class, responseContainer = "List")
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	Object getListCity(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "country", required = true) String country) {
		return cityService.listByNameAndCountry(name, country);
	}

}