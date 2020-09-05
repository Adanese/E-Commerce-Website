package com.Bookstore1.repository;



import org.springframework.data.repository.CrudRepository;

import com.Bookstore1.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	User findByEmail(String email);
}

