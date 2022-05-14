package com.educacionit.jwa.backend.backend.jwa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;
import com.educacionit.jwa.backend.backend.jwa.repositories.DirectorDAO;
import com.educacionit.jwa.backend.backend.jwa.repositories.DirectorDTO;

@Service
public class DirectorService {

	@Autowired
	DirectorDAO directorDAO;
	

	public List<DirectorDTO> findDirectors() {
		List<DirectorModel> directors = (List<DirectorModel>) directorDAO.findAll();
		
		List<DirectorDTO> directorsDTO = new ArrayList<>();
		
		directors.forEach(e -> {
			DirectorDTO directorDTO = new DirectorDTO(e);
			directorsDTO.add(directorDTO);
		});
		
		return directorsDTO;
	}

	public DirectorDTO findDirector(Integer id) {
		
		DirectorModel directorFound = directorDAO.findByid(id);
		
		DirectorDTO directorFoundDTO = new DirectorDTO(directorFound);
		
		return directorFoundDTO;
	}

	public DirectorDTO registerDirector(DirectorModel director) {
		
		director.getproductions().forEach(e -> {
			e.setDirectors(director);
		});
		
		directorDAO.save(director);
		
		DirectorDTO directorRegistered = new DirectorDTO(director);
		
		return directorRegistered;
	}
}
