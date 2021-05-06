package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.beans.UserTable;

public interface UserTableRepository extends JpaRepository<UserTable, Long> {

}
