package com.system.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Apr 11, 2021
 */

@Data
@Entity
@AllArgsConstructor
public class Produce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String category;
	private int shelfLife;
	private LocalDate purchaseDate = LocalDate.now();
	private LocalDate expirationDate = LocalDate.now().plusDays(shelfLife);
	
	
	public Produce() {
		
	}
	
	

}
