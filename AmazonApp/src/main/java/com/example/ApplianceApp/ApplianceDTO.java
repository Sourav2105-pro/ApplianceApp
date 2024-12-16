package com.example.ApplianceApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplianceDTO {
	
private Long id;
	
	private String name;
	private String category;
	private String brand;
	private double price;
	private String energyRating;
	
	public ApplianceDTO(Long id, String name, String brand, double price, String energyRating) {
		this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.energyRating = energyRating ;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEnergyRating() {
		return energyRating;
	}
	public void setEnergyRating(String energyRating) {
		this.energyRating = energyRating;
	}

}
