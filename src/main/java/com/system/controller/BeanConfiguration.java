package com.system.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.system.beans.Grocery;
import com.system.beans.Produce;
import com.system.beans.Recipes;
import com.system.beans.UserTable;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Apr 11, 2021
 */

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Produce produce() {
		
		Produce produce = new Produce();
		return produce;
	}
	
	@Bean
	public Recipes recipes() {
		Recipes recipes = new Recipes();
		return recipes;
	}
	
	@Bean 
	public Grocery gorcery() {
		Grocery g = new Grocery();
		return g;
	}
	
	@Bean
	public UserTable userTable() {
		UserTable uT = new UserTable();
		return uT;
	}

}
