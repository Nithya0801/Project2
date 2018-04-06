package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.Dao.UserDao;
import com.project2.Model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		user.setRole("roleUser");
		if(userDao.insertUser(user))
		{
			return new ResponseEntity<String>("Registered!!!",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failed!!!",HttpStatus.NOT_FOUND);
		}
	}

}
