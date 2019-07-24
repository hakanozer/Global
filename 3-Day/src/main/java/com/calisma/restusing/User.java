package com.calisma.restusing;

public class User {
	
	private String name;
	private int age = 0;
	private boolean statu = false;

	
	public User(String name, int age, boolean statu) {
		super();
		this.name = name;
		this.age = age;
		this.statu = statu;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	
	

}
