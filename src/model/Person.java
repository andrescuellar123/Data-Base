package model;

import java.util.Date;

import javax.swing.JOptionPane;

public class Person {

	private String name, lastName, nacionality, sex, photo;
	private Date dateBirth;
	private double height;
	
	
	public Person(String name, String lastName, String nacionality, String sex, String photo, Date dateBirth,
			double height) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nacionality = nacionality;
		this.sex = sex;
		this.photo = photo;
		this.dateBirth = dateBirth;
		this.height = height;
	}
	
	
	public void subirFotografia() {
		JOptionPane.showMessageDialog(null, "holaa");
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
	
	
	
	
	
}
