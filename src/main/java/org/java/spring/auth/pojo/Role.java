package org.java.spring.auth.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Role {

	
	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	
	
	
	
	
	//COnstructor
	public Role() { }
	public Role(String name) {
		
		setName(name);
	}
	
	
	
	
	
	//Id FUnctions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	//Name functions
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
