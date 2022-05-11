package com.educacionit.jwa.backend.backend.jwa.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productions")
public class FilmModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String gender;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "directorId")
	private DirectorModel director;

	public FilmModel() {
	}

	public FilmModel(Integer id, String name, String gender, DirectorModel director) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.director = director;
	}

	@Override
	public String toString() {
		return "FilmModel [id=" + id + ", name=" + name + ", gender=" + gender + ", director=" + director + "]";
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public DirectorModel getDirector() {
		return director;
	}

	public void setDirectors(DirectorModel director) {
		this.director = director;
	}
	
	
}
