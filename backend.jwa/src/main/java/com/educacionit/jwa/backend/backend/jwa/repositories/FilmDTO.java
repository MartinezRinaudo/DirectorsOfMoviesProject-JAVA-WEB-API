package com.educacionit.jwa.backend.backend.jwa.repositories;

public class FilmDTO {
	private String movies; 
	private String gender; 
	
	public FilmDTO() {
		super();
	}

	public FilmDTO(String movies, String gender) {
		super();
		this.movies = movies;
		this.gender = gender;
	}

	public String getMovies() {
		return movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
