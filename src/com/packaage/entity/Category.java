package com.packaage.entity;

public class Category {
	
	
	int id;
	String name ;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTotalCategoryProduct(int int1) {
		// TODO Auto-generated method stub
		
	}


}
