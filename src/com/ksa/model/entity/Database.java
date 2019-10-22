package com.ksa.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "imdb")
public class Database {

	@XmlElement(name = "movie")
	private List<Movie> movies;

//	public List<Movie> getMovies() {
//		return movies;
//	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
