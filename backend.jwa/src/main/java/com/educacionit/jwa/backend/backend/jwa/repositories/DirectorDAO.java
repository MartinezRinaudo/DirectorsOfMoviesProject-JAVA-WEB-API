package com.educacionit.jwa.backend.backend.jwa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;

@Repository
public interface DirectorDAO extends CrudRepository<DirectorModel, Integer>{
	public DirectorModel findByid(Integer id);
}
