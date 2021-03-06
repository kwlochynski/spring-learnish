package com.wlochynski.learnish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlochynski.learnish.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findUserByUserId(Integer userId);

	@Modifying
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email")
	public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

}