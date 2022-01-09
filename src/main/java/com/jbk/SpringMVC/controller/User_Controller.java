
package com.jbk.SpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.SpringMVC.entity.User;
import com.jbk.SpringMVC.service.UserService_i;

@Controller
public class User_Controller {
	
	@Autowired
	private UserService_i Userservice;
	
	@RequestMapping(value="/")
	public String homepage() {
		return "index";
	}
	
	@RequestMapping(value="/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/registerPage")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="/addUserPage")
	public String addUserPAge() {
		return "user";
	}
	
	@RequestMapping(value="/loginUser")
	public String home(@ModelAttribute User user)
	{
	 boolean b=	Userservice.loginUser(user);
	 
	 if(b==true) {
		 return "home";
	 }
	 else {
		 return "login";
	 }
		
	}
	
	
	@RequestMapping(value="/registerUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		System.out.println(user);
		Userservice.addUser(user);
		
		return new ModelAndView("home","msg","registered");
		
	}
	

}
