package com.tns.placementManagementSystem.restFullAPIs.entity;


//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
@Id	
private Long id;
private String name;
private String password;
public Admin() 
{
}
public Admin(Long id, String name, String password) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
}
}
