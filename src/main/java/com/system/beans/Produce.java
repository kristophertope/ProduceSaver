package com.system.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
//	@ManyToMany(mappedBy = "items_on_list")
//	Set<UserTable> items;
	
	public Produce() {
		
	}
	
	

}
