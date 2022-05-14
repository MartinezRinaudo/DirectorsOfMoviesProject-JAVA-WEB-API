package com.educacionit.jwa.backend.backend.jwa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.jwa.backend.backend.jwa.exceptions.BadRequestException;
import com.educacionit.jwa.backend.backend.jwa.exceptions.ErrorEnum;
import com.educacionit.jwa.backend.backend.jwa.exceptions.NotFoundException;
import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;
import com.educacionit.jwa.backend.backend.jwa.repositories.DirectorDAO;

@Service
public class DirectorService {

	@Autowired
	DirectorDAO directorDAO;

	public List<DirectorModel> findDirectors() {
		List<DirectorModel> directors = (List<DirectorModel>) directorDAO.findAll();
		if (directors == null) {
			throw new NotFoundException(ErrorEnum.INVALIDUSER);
		} else {
			return directors;
		}
	}

	public Optional<DirectorModel> findDirector(Integer id) {
		if (id == null) {
			throw new BadRequestException("Invalid id.", ErrorEnum.WRONGID);
		}
		Optional<DirectorModel> directorFound = directorDAO.findById(id);
		if (directorFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDUSER);
		} else {
			return directorFound;
		}
	}

	public DirectorModel registerDirector(DirectorModel director) {
		if (director.getId() != null) {
			throw new BadRequestException("Exising user.", ErrorEnum.EXISTINGUSER);
		} else {
			director.getproductions().forEach(e -> {
				e.setDirectors(director);
			});
			directorDAO.save(director);
			return director;
		}
	}
	/*
	 * public List<DirectorDTO> findDirectors() { List<DirectorModel> directors =
	 * (List<DirectorModel>) directorDAO.findAll(); List<DirectorDTO> directorsDTO =
	 * new ArrayList<>();
	 * 
	 * directors.forEach(e -> { DirectorDTO directorDTO = new DirectorDTO(e);
	 * directorsDTO.add(directorDTO); });
	 * 
	 * return directorsDTO; }
	 * 
	 * public DirectorDTO findDirector(Integer id) {
	 * 
	 * DirectorModel directorFound = directorDAO.findByid(id);
	 * 
	 * DirectorDTO directorFoundDTO = new DirectorDTO(directorFound);
	 * 
	 * return directorFoundDTO; }
	 * 
	 * public DirectorDTO registerDirector(DirectorModel director) {
	 * 
	 * director.getproductions().forEach(e -> { e.setDirectors(director); });
	 * 
	 * directorDAO.save(director);
	 * 
	 * DirectorDTO directorRegistered = new DirectorDTO(director);
	 * 
	 * return directorRegistered; }
	 */

}
