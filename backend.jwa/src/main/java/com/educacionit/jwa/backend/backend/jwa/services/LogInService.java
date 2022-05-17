package com.educacionit.jwa.backend.backend.jwa.services;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.educacionit.jwa.backend.backend.jwa.models.LogInModel;
import com.educacionit.jwa.backend.backend.jwa.repositories.LogInDAO;
import com.educacionit.jwa.backend.backend.jwa.security.JWTTokenGeneration;

@Service
public class LogInService {

	@Autowired
	LogInDAO logInDAO;
	@Autowired
	JWTTokenGeneration jwtToken;

	public String startSession(LogInModel user) throws IOException {
		LogInModel userDB = logInDAO.findByUserName(user.getUserName());
		if (userDB != null && userDB.getPassword().equals(user.getPassword())) {
			String token = jwtToken.generateToken(user);
			return token;
		} else {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid Credentials");
			return "";
		}
	}

	public String registerNewUser(LogInModel user) throws IOException {
		LogInModel userDB = logInDAO.findByUserName(user.getUserName());
		if (userDB != null) {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.sendError(HttpStatus.BAD_REQUEST.value(), "This user already exists.");
			return "";
		} else {
			String token = jwtToken.generateToken(user);
			logInDAO.save(user); 
			return token;
		}
	}
}
