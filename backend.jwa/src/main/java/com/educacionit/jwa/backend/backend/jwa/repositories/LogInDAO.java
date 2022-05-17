package com.educacionit.jwa.backend.backend.jwa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.educacionit.jwa.backend.backend.jwa.models.LogInModel;

public interface LogInDAO extends CrudRepository<LogInModel, Integer>{

	public LogInModel findByUserName(String userName);
}
