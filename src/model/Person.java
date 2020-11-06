package model;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;


public class Person {

	private String name, lastName, nacionality, sex, photo;
	private LocalDate dateBirth;
	private int height;
	private int code;
	
	
	public Person(String name, String lastName, String nacionality, String sex, String photo, LocalDate dateBirth,
			int height, int code) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nacionality = nacionality;
		this.sex = sex;
		this.photo = photo;
		this.dateBirth = dateBirth;
		this.height = height;
		this.code= code;
	}
	

	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
	public LocalDate getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	
}
