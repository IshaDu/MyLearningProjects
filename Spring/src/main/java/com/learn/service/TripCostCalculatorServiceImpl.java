package com.learn.service;

import org.springframework.stereotype.Component;

@Component
public class TripCostCalculatorServiceImpl implements TripCostCalculatorService{

	public double costCalculator(float carMileage, float gasPrice, float distanceTraveled) {
		return  (distanceTraveled * gasPrice)/carMileage;
	}

}
