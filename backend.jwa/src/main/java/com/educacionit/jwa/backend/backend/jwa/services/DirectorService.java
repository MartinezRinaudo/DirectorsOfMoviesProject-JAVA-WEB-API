package com.educacionit.jwa.backend.backend.jwa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;
import com.educacionit.jwa.backend.backend.jwa.repositories.DirectorDAO;

@Service
public class DirectorService {

	@Autowired
	DirectorDAO directorDAO;
	

	public List<DirectorModel> findDirectors() {
		return (List<DirectorModel>) directorDAO.findAll();
	}

	public DirectorModel findDirector(Integer id) {
		DirectorModel directorFound = directorDAO.findByid(id);
		return directorFound;
	}

	public DirectorModel registerDirector(DirectorModel director) {
		director.getproductions().forEach(e -> e.setDirectors(director));
		directorDAO.save(director);
		//System.out.println(findDirector(director.getId()));
		return findDirector(director.getId());
	}
}
