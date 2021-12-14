package com;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="appointment")

public class appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
private int id;
private String patientname;
private int age;
private long contactno;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
private String discription;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPatientname() {
	return patientname;
}
public void setPatientname(String patientname) {
	this.patientname = patientname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}


public String getDiscription() {
	return discription;
}
public void setDiscription(String discription) {
	this.discription = discription;
}
}
