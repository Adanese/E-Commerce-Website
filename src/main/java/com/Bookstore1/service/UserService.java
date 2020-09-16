package com.Bookstore1.service;


import java.util.Set;

import com.Bookstore1.domain.User;
import com.Bookstore1.domain.security.PasswordResetToken;
import com.Bookstore1.domain.security.UserRole;

public interface UserService {
PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
