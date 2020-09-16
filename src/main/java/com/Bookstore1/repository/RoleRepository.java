package com.Bookstore1.repository;

import org.springframework.data.repository.CrudRepository;

import com.Bookstore1.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}

