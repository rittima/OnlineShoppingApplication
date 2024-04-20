package com.shopping.app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "product")
public class Product {

	
	private String name;
    private double price;
    private String description;
    private String category;
    private String brand;
    private int quantityAvailable;
    private String imageUrl;
    private double rating;
    private List<String> reviews;
    
	public Product(String name, double price, String description, String category, String brand,
			int quantityAvailable, String imageUrl, double rating, List<String> reviews) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.quantityAvailable = quantityAvailable;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.reviews = reviews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", category=" +
				category + ", brand=" + brand + ", quantityAvailable=" + quantityAvailable + ", imageUrl=" + 
				imageUrl + ", rating=" + rating + ", reviews=" + reviews + "]";
	} 
    
}
