package com.dollarsbank.model;

import java.io.Serializable;

public class Items implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public Items() {
		this(-1, "N/A", "N/A", -1);
	}
	
	public Items(int item_id, String item_name, String item_code, double item_price) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_code = item_code;
		this.item_price = item_price;
	}

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	private int item_id;
	private String item_name;
	private String item_code;
	private double item_price;

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", item_name=" + item_name + ", item_code=" + item_code + ", item_price="
				+ item_price + "]";
	}
	
}
