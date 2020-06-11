package com.wlochynski.learnish.servicesImpl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.learnish.model.Role;
import com.wlochynski.learnish.model.User;
import com.wlochynski.learnish.repositories.RoleRepository;
import com.wlochynski.learnish.repositories.UserRepository;
import com.wlochynski.learnish.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	public User findUserByUserId(Integer userId) {
		return userRepository.findUserByUserId(userId);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);

		Role role = roleRepository.findByRole("ROLE_ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));

		userRepository.save(user);

	}

	@Override
	public void updateUserPassword(String newPassword, String email) {
		userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
	}

}
