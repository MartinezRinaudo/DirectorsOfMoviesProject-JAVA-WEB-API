package com.educacionit.jwa.backend.backend.jwa.repositories;

import java.util.ArrayList;
import java.util.List;

import com.educacionit.jwa.backend.backend.jwa.models.DirectorModel;

public class DirectorDTO {
	
	private static List<FilmDTO> movies = new ArrayList<>();
	private Integer id;
	private String name;
	private String lastname;
	private List<FilmDTO> productions = new ArrayList<>();
	
	public DirectorDTO() {
		super();
	}

	public DirectorDTO(DirectorModel director) {
		super();
		this.id = director.getId();
		this.name = director.getName();
		this.lastname = director.getLastname();
		
		movies.clear();;
		
		director.getproductions().forEach(e -> {
			String filmName = e.getName();
			String genders = e.getGender();
			FilmDTO film = new FilmDTO(filmName, genders);
			movies.add(film);
		});
		
		this.productions = movies;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public static List<FilmDTO> getMovies() {
		return movies;
	}

	public static void setMovies(List<FilmDTO> movies) {
		DirectorDTO.movies = movies;
	}

	public List<FilmDTO> getProductions() {
		return productions;
	}

	public void setProductions(List<FilmDTO> productions) {
		this.productions = productions;
	}

	

	
	
	
}
