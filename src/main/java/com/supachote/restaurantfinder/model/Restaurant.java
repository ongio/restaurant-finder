package com.supachote.restaurantfinder.model;

public class Restaurant {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private int reviewCount;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	@Override
	public String toString() {
		return "Restaurant ["
				+ "id=" + id
				+ ", name=" + name
				+ ", address=" + address
				+ ", phone" + phone
				+ ", reviewCount" + reviewCount
				+ "]";
	}
}
