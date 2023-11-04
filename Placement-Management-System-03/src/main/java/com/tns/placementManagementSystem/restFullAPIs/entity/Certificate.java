package com.tns.placementManagementSystem.restFullAPIs.entity;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Certificate
{ 
@Id
private Long id;
private Integer year;
private String college;
public Certificate() {
	
}
public Certificate(Long id, Integer year, String college) {
	super();
	this.id = id;
	this.year = year;
	this.college = college;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
@Override
public String toString() {
	return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
}
}