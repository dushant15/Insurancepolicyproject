package com.jbk.SpringMVC.dao;

import com.jbk.SpringMVC.entity.User;

public interface UserDao_i {
	public boolean loginUser(User  user);

	public void addUser(User user);
}
