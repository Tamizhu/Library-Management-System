package com.library.repo;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    

	 

	List<User> findAll();
}
