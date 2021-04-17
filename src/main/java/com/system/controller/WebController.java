package com.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.beans.Grocery;
import com.system.beans.Produce;
import com.system.beans.Recipes;
import com.system.repository.GroceryInterface;
import com.system.repository.MenuRepository;
import com.system.repository.ProduceAppRepository;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Apr 12, 2021
 */
@Controller
public class WebController {
	
	@Autowired
	ProduceAppRepository repo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	GroceryInterface groceryRepo;
	
	//All this section is the related to products 
	@GetMapping({"/viewProduceList"})
	public String viewProduceList(Model model) {
		if(repo.findAll().isEmpty()) {
			return inputProduce(model);
		}
		model.addAttribute("produce", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputProduce")
	public String inputProduce(Model model) {
		Produce b = new Produce();
		model.addAttribute("newProduce", b);
		return "input";
	}
	
	@PostMapping("/inputProduce")
	public String inputProduce(@ModelAttribute Produce b, Model model) {
		repo.save(b);
		return viewProduceList(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateProduce(@PathVariable("id") long id, Model model) {
		Produce b = repo.findById(id).orElse(null);
		model.addAttribute("newProduce", b);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseBook(@Valid Produce b, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "input";
		}
		
		repo.save(b);
		return viewProduceList(model);
	}
	//Here ends the products section
	
	//All this section is related to the meal plan
				
	@GetMapping("/menuOptions")
	public String menuOptions(Model model) {
		if(menuRepo.findAll().isEmpty()) {
			return inputMenu(model);
		}
		model.addAttribute("option", menuRepo.findAll());
		return "menu";
	}
	
	@GetMapping("/inputMenu")
	public String inputMenu(Model model){
		Recipes r = new Recipes();
		model.addAttribute("newRecipe", r);
		return "inputMenu";
		
	}
	
	@PostMapping("/inputMenu")
	public String inputMenu(@ModelAttribute Recipes re, Model model) {
		
		groceryRepo.save(re.getGrocery());
		menuRepo.save(re);
		return menuOptions(model);
	}
	
	@GetMapping("/menuGroceryList")
	public String menuGroceryList(Model model) {

		model.addAttribute("product", groceryRepo.findAll());
		return "groceryList";
	}
	

}





































