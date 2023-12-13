package org.java.spring.dto;

public class PizzaSpecialSaleDTO {

	
	private int pizza_id;
	private String nome;
	private String starting_date;
	private String end_date;
	
	
	
	public String getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getPizza_id() {
		return pizza_id;
	}
	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}
	
	
	public String getTitle() {
		return nome;
	}
	public void setTitle(String nome) {
		this.nome = nome;
	}
}
