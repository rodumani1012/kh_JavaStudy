package io.object.model.vo;

import java.io.Serializable;

/**
 * @author 
 *
 */
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 직렬화 아이디를 고정값으로 주면
	//Member 클래스가 변경되어도 아이디가 변경되지 않아 InvalidClassException 에러가 발생하지 않는다.
	private String name;
	private int age;
	private char gender;
	private double height;
//	private double weight;
	
	public Member() {
		
	}

	public Member(String name, int age, char gender, double height) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height + "]";
	}
	 
}
