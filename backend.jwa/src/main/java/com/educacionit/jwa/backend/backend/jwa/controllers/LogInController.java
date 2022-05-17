package com.educacionit.jwa.backend.backend.jwa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.jwa.backend.backend.jwa.models.LogInModel;
import com.educacionit.jwa.backend.backend.jwa.services.LogInService;

@RestController
@RequestMapping("API/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET })
public class LogInController {

	@Autowired
	LogInService loginServ;
	
	@PostMapping(path = "/signup")
	ResponseEntity<String> signup(@RequestBody LogInModel user) throws IOException {
		return new ResponseEntity<>(loginServ.registerNewUser(user), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/login")
	ResponseEntity<String> login(@RequestBody LogInModel user) throws IOException {
		return new ResponseEntity<>(loginServ.startSession(user), HttpStatus.OK);
	}


}
