package com.educacionit.jwa.backend.backend.jwa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class DirectorModel extends PersonModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String lastname;
	//private String movies;
	
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
	private List<FilmModel> productions = new ArrayList<>();
	 
	
	@Override
	public String toString() {
		return "DirectorModel [id=" + id + ", name=" + name + ", lastname=" + lastname + ", productions=" + productions
				+ "]";
	}

	public DirectorModel() {
	}

	public DirectorModel(Integer id, String name, String lastname, List<FilmModel> productions) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.productions = productions;
	}
	
	public void addMovie(FilmModel movie) {
		productions.add(movie);
		movie.setDirectors(this);
	}
	
	public void removeMovie(FilmModel movie) {
		productions.remove(movie);
		movie.setDirectors(null);
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

	public List<FilmModel> getproductions() {
		return productions;
	}

	public void setProductions(List<FilmModel> productions) {
		this.productions = productions;
	}

}
