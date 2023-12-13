package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.Ingredient;
import org.java.spring.pojo.Pizza;
import org.java.spring.serv.IngredientService;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IngredientsController {

	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private PizzaService pizzaService;
	
	
	//********** Routes
	@GetMapping("/ingredients")
	public String getIngredients(Model model, @RequestParam(required = false) String q) {
		
		
		List<Ingredient> ingredients = ingredientService.findAll();
		
		model.addAttribute("ingredients", ingredients);
		
		return "ingredients";
	}
	
	
	
	
	@GetMapping("/ingredients/create")
	public String createIngredient(Model model) {
		
		Ingredient ingredient = new Ingredient();
		
		model.addAttribute("ingredient", ingredient);
		
		return "ingredient-form";
		
	}
	
	
	
	@PostMapping("/ingredients/create")
	public String storeIngredient(Model model, @Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult ) {
		
		ingredientService.save(ingredient);
		return "redirect:/ingredients";
		
	}
	
	
	
	@PostMapping("/ingredients/delete/{id}")
	public String deleteIngredient (@PathVariable int id) {
		
		Ingredient ingredient = ingredientService.findById(id);
		
		/* List<Pizza> pizzas = ingredient.getPizza();
		
		for(Pizza pizza : pizzas) {
			if(pizza.getId() == ingredient.getId()) {
				pizza.getIngredients().remove(ingredient);
			}
		} */
		
		
		List<Pizza> Pizzas = ingredient.getPizza();
		Pizzas.forEach(p -> {
			
			p.getIngredients().remove(ingredient);
			pizzaService.save(p);
		});
		
		ingredientService.delete(ingredient);
		
		return "redirect:/";
	}
	
}
