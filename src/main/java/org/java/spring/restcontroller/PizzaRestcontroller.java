package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.pojo.Pizza;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/pizza")
public class PizzaRestcontroller {

	
	//Declaring variables
	@Autowired
	private PizzaService pizzaService;
	
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getIndex() {
		
		List<Pizza> pizzas = pizzaService.findAll();
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<Pizza> getPizza(@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		
		if (pizza == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
}
