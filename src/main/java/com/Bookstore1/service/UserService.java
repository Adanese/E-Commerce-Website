package com.Bookstore1.service;


import com.Bookstore1.domain.User;
import com.Bookstore1.domain.security.PasswordResetToken;

public interface UserService {
PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
}
