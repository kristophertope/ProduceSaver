package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.beans.Grocery;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Apr 15, 2021
 */
@Repository
public interface GroceryInterface extends JpaRepository<Grocery, Long>{

}
