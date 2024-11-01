package com.example.sbweb.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbweb.entities.Users;
import com.example.sbweb.services.UsersService;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	
	
	@PostMapping("/register")
	public String addUser(@ ModelAttribute Users user) {
		boolean userstatus=userv.emailExists(user.getEmail());
		if(userstatus ==false) {
			userv.addUser(user);
			return "registersuccess";
		}
		else {
			return "registerfail";
		}
		
	
	}
	
	@PostMapping("/login")//login module
	public String validateUser(@RequestParam String email ,@RequestParam String password)
	{
		//invoking validaateUser() in service
		if(userv.validateUser(email,password)==true)
		{
			//checking whether the user is admin or customer
		if(userv.getRole(email).equals("admin")) {
			return "adminhome";
		}
		else {
			return "customerhome";
		}
		}
		else {
			return "loginfail";
		}
		

	}
	}
