package org.java.spring.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;


@Entity
public class Pizza {

	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(min = 3, max = 40, message = "Il nome deve essere compreso tra i 3 e i 40 caratteri")
	private String nome;
	
	private String descrizione;
	private String url;
	
	@NotNull
	private double price;
	
	@OneToMany(mappedBy = "pizza")
	private List<SpecialSale> specialSale;
	
	
	@ManyToMany
	private List<Ingredient> ingredients;
	
	
	//Constructor 
	public Pizza() { }
	public Pizza(String nome, String descrizione, String url, double price, Ingredient...ingredients) {
		
		setNome(nome);
		setDescrizione(descrizione);
		setUrl(url);
		setPrice(price);
		setIngredients(ingredients);
		
	}
	
	
	
	
	
	//Id Functions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//Name functions
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	//Description functions
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	//URL functions
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	//Price functions
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	//Relation Functions
	public List<SpecialSale> getSpecialSale() {
		return specialSale;
	}
	public void setSpecialSale(List<SpecialSale> specialSale) {
		this.specialSale = specialSale;
	}
	
	
	
	
	// Ingredients functions
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public void setIngredients(Ingredient... ingredients) {	
		setIngredients(Arrays.asList(ingredients));
	}
	public void clearIngredients() {
		getIngredients().clear();
	}
	
	
}
