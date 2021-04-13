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

import com.system.beans.Produce;
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
	
	@GetMapping({"/", "/viewProduceList"})
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
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id, Model model) {
		Produce b = repo.findById(id).orElse(null);
		repo.delete(b);
		return viewProduceList(model);
				
	}

}
