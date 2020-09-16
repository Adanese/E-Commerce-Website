package com.Bookstore1.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookstore1.domain.User;
import com.Bookstore1.domain.security.PasswordResetToken;
import com.Bookstore1.domain.security.UserRole;
import com.Bookstore1.repository.PasswordResetTokenRepository;
import com.Bookstore1.repository.RoleRepository;
import com.Bookstore1.repository.UserRepository;
import com.Bookstore1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			throw new Exception("user already exists.  Nothing will be done");
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}

		return localUser;
	}

}
