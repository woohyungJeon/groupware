package com.ezenit.eroupware.example.bean;

public class ExampleDTO {
	
	private String name;
	private int age;
	private String memo;
	
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "ExampleDTO [name=" + name + ", age=" + age + ", memo=" + memo + "]";
	}

}
