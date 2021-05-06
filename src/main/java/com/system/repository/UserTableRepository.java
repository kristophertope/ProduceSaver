package com.system.repository;

/**
 * @author Alex Ryberg - alexr151
 * CIS175 - Spring 2021
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.beans.UserTable;

public interface UserTableRepository extends JpaRepository<UserTable, Long> {

}
