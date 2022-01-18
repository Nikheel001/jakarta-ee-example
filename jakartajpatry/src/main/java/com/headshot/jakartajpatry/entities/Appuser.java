package com.headshot.jakartajpatry.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Appuser {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	private String lastName;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long get_id() {
		return id;
	}

	public void set_id(long _id) {
		this.id = _id;
	}

	@Override
	public String toString() {
		return String.format("User [firstName=%s, lastName=%s, age=%s]", firstName, lastName, age);
	}

}
