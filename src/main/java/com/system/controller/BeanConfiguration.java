package com.system.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.system.beans.Produce;

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

}
