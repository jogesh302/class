package com.mtc.vo;

public class Items {

	private int id;
	private String name;
	private float price;
	private String describtion;

	public Items() {

	}

	public Items(int id, String name, float price, String describtion) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.describtion = describtion;
	}

	@Override
	public String toString() {
	
		return "Item_Id    "+id+"   Item_Name   "+name+"   Item_Price    "+price+"   Item_description    "+describtion;
	}
	
	
	
	
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

}
