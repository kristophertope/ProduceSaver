package com.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.system.beans.UserTable;
import com.system.repository.GroceryInterface;
import com.system.repository.MenuRepository;
import com.system.repository.ProduceAppRepository;
import com.system.repository.UserTableRepository;

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
	@Autowired
	UserTableRepository userTableRepo;
	
	//All this section is the related to products 
	@GetMapping({"/viewProduceList"})
	public String viewProduceList(Model model) {
		if(repo.findAll().isEmpty()) {
			return inputProduce(model);
		}
		model.addAttribute("produce", repo.findAll());
		return "testland";
	}
	
	@GetMapping({"/viewProduce"})
	public String viewProduce(Model model) {
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
	
	@GetMapping("/delete/{id}")
	public String deleteProduce(@PathVariable("id") long id, Model model) {
		Produce p = repo.findById(id).orElse(null);
		repo.delete(p);
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
		Grocery g = new Grocery();
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
		if(groceryRepo.findAll().isEmpty()) {
			return menuOptions(model);
		}
		model.addAttribute("product", groceryRepo.findAll());
		return "groceryList";
	}
	

	//Ends the menu section
	
	//begins user table function
	
	@GetMapping({"/newUserTable"})
	public String newTable(Model model) {
		UserTable uT = new UserTable();
		model.addAttribute("newUserTable", uT);
		return "newTable";
	}
	
	@PostMapping("/newUserTable")
	public String newTable(@ModelAttribute UserTable uT, Model model) {
		userTableRepo.save(uT);
		return "testLand";
	}
	
	@PostMapping("/addToTable")
	public String reviseBook(@Valid UserTable uT, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "emailList";
		}
		userTableRepo.getOne(uT.getListId());
		return viewProduceList(model);
	}
	
	@GetMapping({"/viewEmailList"})
	public String viewEmailList(Model model) {
		if(userTableRepo.findAll().isEmpty()) {
			return inputProduce(model);
		}
		model.addAttribute("userTable", userTableRepo.findAll());
		return "emailList";
	}
	
	

	@GetMapping("/deleteGrocery/{id}")
	public String deleteGrocery(@PathVariable("id") long id, Model model) {
		Grocery gr = groceryRepo.findById(id).orElse(null);
		groceryRepo.delete(gr);
		
		return menuGroceryList(model);
	}
	
	
	//This section is related to recipes
	@GetMapping("/deleteRecipe/{id}")
	public String deleteRecipe(@PathVariable("id") long id, Model model) {
		Recipes r = menuRepo.findById(id).orElse(null);
		menuRepo.delete(r);
		groceryRepo.delete(r.getGrocery());
		return menuOptions(model);
	}
	
}





































