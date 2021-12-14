package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String yourname;
	private String email;
	private String yourmessage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYourname() {
		return yourname;
	}
	public void setYourname(String yourname) {
		this.yourname = yourname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYourmessage() {
		return yourmessage;
	}
	public void setYourmessage(String yourmessage) {
		this.yourmessage = yourmessage;
	}
}
