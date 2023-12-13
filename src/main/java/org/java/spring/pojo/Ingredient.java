package org.java.spring.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingredient {

	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Pizza> pizzas;
	
	
	//Constructor
	public Ingredient() { }
	
	public Ingredient(String title) {
		
		setTitle(title);
	}

	
	
	//Id functions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	//Title functions
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	//Get Pizza
	public List<Pizza> getPizza() {
		return pizzas;
	}
}
