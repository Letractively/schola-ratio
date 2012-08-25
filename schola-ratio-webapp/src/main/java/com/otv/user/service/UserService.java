package com.otv.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otv.model.User;
import com.otv.user.dao.IUserDAO;

/**
 * 
 * User Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Service("userService")
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
	public List<User> getUsers() {	
		return userDAO.getUsers();
	}


}
