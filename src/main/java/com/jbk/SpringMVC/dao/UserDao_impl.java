package com.jbk.SpringMVC.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.SpringMVC.entity.User;

@Repository
public class UserDao_impl implements UserDao_i {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();

	}

	@Override
	public boolean loginUser(User user) {
		boolean b=false;
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" SELECT username,password FROM User WHERE username=:un and password=:pass");
		query.setString("un", user.getUsername());
		query.setString("pass", user.getPassword());
		List list = query.list();
		if (!list.isEmpty()) {
			b=true;
		}
			

			return b;
	}

}
