package com.learnSpring.model;

import jakarta.persistence.Entity;

@Entity
public class BeautyTreatments {
	
	private int beautyTreatmentId;
	private String beautyTreatmentName;
	private String beautyTreatmentPrice;
	
	public BeautyTreatments() {
		super();
	}
	
	public BeautyTreatments(String beautyTreatmentName, String beautyTreatmentPrice) {
		super();
		this.beautyTreatmentName = beautyTreatmentName;
		this.beautyTreatmentPrice = beautyTreatmentPrice;
	}
	
	public String getBeautyTreatmentName() {
		return beautyTreatmentName;
	}
	
	public void setBeautyTreatmentName(String beautyTreatmentName) {
		this.beautyTreatmentName = beautyTreatmentName;
	}
	
	public String getBeautyTreatmentPrice() {
		return beautyTreatmentPrice;
	}
	
	public void setBeautyTreatmentPrice(String beautyTreatmentPrice) {
		this.beautyTreatmentPrice = beautyTreatmentPrice;
	}
	public int getBeautyTreatmentId() {
		return beautyTreatmentId;
	}

	public void setBeautyTreatmentId(int beautyTreatmentId) {
		this.beautyTreatmentId = beautyTreatmentId;
	}		
}
