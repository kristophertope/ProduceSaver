package com.system.beans;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
//@Embeddable

public class Grocery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	//private List<String> ingredientsList;
	
	public Grocery() {
		// TODO Auto-generated constructor stub
	}
	
	public Grocery(String name) {
		this.name = name;
	}
	
	

}
