package com.otv.user.dao;

import java.util.List;

import com.otv.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * User DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Repository("userDao")
public class UserDAO extends HibernateDaoSupport implements IUserDAO{

	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	@Override
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}

	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	@Override
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param  int User Id
	 * @return User 
	 */
	@Override
	public User getUserById(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		return user;
	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	@Override
	public List<User> getUsers() {
		List list = getHibernateTemplate().loadAll(User.class);
		return list;
	}

    @Autowired
    public void addSessionFactoryToDao(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
}
