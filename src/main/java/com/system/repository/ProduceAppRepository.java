package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.beans.Produce;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Apr 12, 2021
 */
@Repository
public interface ProduceAppRepository extends JpaRepository<Produce, Long>{

}
