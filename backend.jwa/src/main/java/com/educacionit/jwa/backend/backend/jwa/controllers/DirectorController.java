package com.educacionit.jwa.backend.backend.jwa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;
import com.educacionit.jwa.backend.backend.jwa.services.DirectorService;

@RestController
@RequestMapping("API/directors")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
public class DirectorController {

	@Autowired
	DirectorService directorServ;
	
	@GetMapping()
	ResponseEntity<List<DirectorModel>>getDirectors() {
		return new ResponseEntity<>(directorServ.findDirectors(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" )
	ResponseEntity<Optional<DirectorModel>>getDirector(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(directorServ.findDirector(id), HttpStatus.OK);
	}
	
	@PostMapping()
	ResponseEntity<DirectorModel>postDirector(@RequestBody DirectorModel director) {
		return new ResponseEntity<>(directorServ.registerDirector(director), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	ResponseEntity<DirectorModel>putDirector(@RequestBody DirectorModel director) {
		return new ResponseEntity<>(directorServ.updateDirector(director), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<DirectorModel>deleteDirector(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(directorServ.removeDirector(id), HttpStatus.OK);
	}
}
