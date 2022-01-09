package com.jbk.SpringMVC.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.SpringMVC.dao.UserDao_i;
import com.jbk.SpringMVC.entity.User;

@Service
@Transactional
public class UserService_impl implements UserService_i {

	@Autowired
	private UserDao_i UserDao;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		UserDao.addUser(user);
	}

	@Override
	public boolean loginUser(User user) {
		
	 boolean b=	UserDao.loginUser(user);
		return b;
	}

}
