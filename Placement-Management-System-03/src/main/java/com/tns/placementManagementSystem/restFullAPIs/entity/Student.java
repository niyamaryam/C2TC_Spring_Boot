package com.tns.placementManagementSystem.restFullAPIs.entity;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table (name = "students")
public class Student 
{
	
//	          CREATE TABLE students (
//			  id int NOT NULL,
//			  name varchar(255) NOT NULL,
//			  college varchar(255) NOT NULL,
//			  roll_number bigint(20) NOT NULL,
//			  qualification varchar(255) NOT NULL,
//			  course varchar(255) NOT NULL,
//			  year int(11) NOT NULL,
//			  certificate varchar(255) NOT NULL,
//			  hall_ticket_no bigint(20) NOT NULL,
//			  PRIMARY KEY (id)
//			);

	@Id
	private Long id;
	private String name;
	private String college;
	private Long roll_number;
	private String qualification;
	private String course;
	private Integer year;
	private String certificate;
	private Long hall_ticket_no;
	
	public Student(){
	}

	public Student(Long id, String name, String college, Long roll_number, String qualification, String course,
			Integer year, String certificate, Long hall_ticket_no) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.roll_number = roll_number;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.certificate = certificate;
		this.hall_ticket_no = hall_ticket_no;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Long getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(Long roll_number) {
		this.roll_number = roll_number;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Long getHall_ticket_no() {
		return hall_ticket_no;
	}

	public void setHall_ticket_no(Long hall_ticket_no) {
		this.hall_ticket_no = hall_ticket_no;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", roll_number=" + roll_number
				+ ", qualification=" + qualification + ", course=" + course + ", year=" + year + ", certificate="
				+ certificate + ", hall_ticket_no=" + hall_ticket_no + "]";
	}
	
}

