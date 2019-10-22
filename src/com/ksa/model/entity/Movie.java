package com.ksa.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "movie")
public class Movie {

	@XmlElement
	private String title;

	@XmlElement
	private Integer year;

	@XmlElement
	private Double rating;

	@XmlElementWrapper(name = "ds")
	@XmlElement(name = "director")
	private List<Director> directors;

	@XmlElementWrapper(name = "genres")
	@XmlElement(name = "item")
	private List<String> genres;

	@XmlElementWrapper(name = "ws")
	@XmlElement(name = "writer")
	private List<Writer> writers;

	@XmlElementWrapper(name = "cts")
	@XmlElement(name = "country")
	private List<String> countries;

	@XmlElementWrapper(name = "ls")
	@XmlElement(name = "language")
	private List<String> languages;

	@XmlElementWrapper(name = "cps")
	@XmlElement(name = "company")
	private List<String> companies;

	@XmlElementWrapper
	@XmlElement(name = "p")
	private List<CastMember> cast;

	@XmlElementWrapper(name = "kws")
	@XmlElement(name = "kw")
	private List<String> keywords;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public void setCompanies(List<String> companies) {
		this.companies = companies;
	}

	public void setCast(List<CastMember> cast) {
		this.cast = cast;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Movie() {}

	public Movie(String title, Integer year, Double rating, List<Director> directors,
				 List<String> genres, List<Writer> writers, List<String> countries,
				 List<String> languages, List<String> companies, List<CastMember> cast,
				 List<String> keywords) {
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.directors = directors;
		this.genres = genres;
		this.writers = writers;
		this.countries = countries;
		this.languages = languages;
		this.companies = companies;
		this.cast = cast;
		this.keywords = keywords;
	}
}
