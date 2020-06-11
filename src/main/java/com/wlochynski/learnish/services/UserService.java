package com.wlochynski.learnish.services;

import com.wlochynski.learnish.model.User;

public interface UserService {
	public User findUserByEmail(String email);

	public User findUserByUserId(Integer userId);

	public void saveUser(User user);

	public void updateUserPassword(String newPassword, String email);

}