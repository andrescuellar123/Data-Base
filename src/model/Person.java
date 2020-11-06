package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class Person {

	private String name, lastName, nacionality, sex, photo;
	private Date dateBirth;
	private double height;
	public Person left;
	public Person right;
	private int fe;
	
	   
	public Person(String name, String lastName, String nacionality, String sex, Date dateBirth,
			double height) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nacionality = nacionality;
		this.sex = sex;
		this.dateBirth = dateBirth;
		this.height = height;
		this.fe=0;
		left=null;
		right=null;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNacionality() {
		return nacionality;
	}
	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Person getRight() {
		return right;
	}
	public void setRight(Person right) {
		this.right = right;
	}
	public Person getLeft() {
		return left;
	}
	public void setLeft(Person left) {
		this.left = left;
	}
	public int getFe() {
		return fe;
	}
	public void setFe(int fe) {
		this.fe = fe;
	}




	


	
	
	
	
	
	
}
