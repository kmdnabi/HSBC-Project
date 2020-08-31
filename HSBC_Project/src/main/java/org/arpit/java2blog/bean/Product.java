package org.arpit.java2blog.bean;

public class Product {
	
	private int id;
	private String category;
	private String compeny;
	private String productModel;
	private String color;
	private String description;
	private double price;
	private double discount;
	private int in_stack_count;
	
	public Product() {
		super();
	}

	

	

	public Product(int id, String category, String compeny, String productModel, String color, String description,
			double price, double discount, int in_stack_count) {
		super();
		this.id = id;
		this.category = category;
		this.compeny = compeny;
		this.productModel = productModel;
		this.color = color;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.in_stack_count = in_stack_count;
	}





	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompeny() {
		return compeny;
	}

	public void setCompeny(String compeny) {
		this.compeny = compeny;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getIn_stack_count() {
		return in_stack_count;
	}

	public void setIn_stack_count(int in_stack_count) {
		this.in_stack_count = in_stack_count;
	}
	
	
	

}
