package org.java.spring.controller;


import java.util.List;

import org.java.spring.pojo.Ingredient;
import org.java.spring.pojo.Pizza;
import org.java.spring.pojo.SpecialSale;
import org.java.spring.serv.IngredientService;
import org.java.spring.serv.PizzaService;
import org.java.spring.serv.SpecialSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class MainController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialSaleService specialSaleService;
	
	@Autowired
	private IngredientService ingredientService;
	
	
	//********** Routes
	@GetMapping
	public String getPizzas(Model model, @RequestParam(required = false) String q) {
		
		
		List<Pizza> pizzas = q == null ? pizzaService.findAll() : pizzaService.findByName(q);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("q", q == null ? "" : q);
		
		return "index";
	}
	
	
	
	@GetMapping("/pizza/{id}")
	public String getBook(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
	
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		List<Ingredient> ingredients = ingredientService.findAll();
		
		model.addAttribute("pizza", pizza);
		model.addAttribute("ingredients", ingredients);
		
		return "pizza-form";
		
	}
	
	
	
	@PostMapping("/pizza/create")
	public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult ) {
		
		return savePizza(model, pizza, bindingResult);
		
	}
	
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(Model model, @PathVariable int id) {
		
		List<Ingredient> ingredients = ingredientService.findAll();
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		model.addAttribute("ingredients", ingredients);
		
		return "pizza-form";
	}
	
	
	@PostMapping("/pizza/edit/{id}")
	public String updatePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		
		
		return savePizza(model, pizza, bindingResult);
	}
	
	
	@PostMapping("/pizza/delete/{id}")
	public String deletePizza (@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		
		pizza.clearIngredients();
		pizzaService.save(pizza);
		
		List<SpecialSale> specialSales = pizza.getSpecialSale();
		specialSales.forEach(specialSaleService::delete);
		
		pizzaService.delete(pizza);
		
		return "redirect:/";
	}
	
	
	
	//Functions
	public String savePizza(Model model, @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("pizza", pizza);
			return "pizza-form";
			
		} else {
			
			pizzaService.save(pizza);
			return "redirect:/";
		}
	}
	
}
