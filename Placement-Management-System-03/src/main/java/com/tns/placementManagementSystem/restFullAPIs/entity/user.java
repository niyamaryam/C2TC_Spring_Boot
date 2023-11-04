package com.tns.placementManagementSystem.restFullAPIs.entity;

//Entity class
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity

public class user {
@Id
private Integer id;
private String name;
private char password;
public user()
{
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public char getPassword() {
	return password;
}
public void setPassword(char password) {
	this.password = password;
}
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", password=" + password + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
public user(Integer id, String name, char password) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
} }