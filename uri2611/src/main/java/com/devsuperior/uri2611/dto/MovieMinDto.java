package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.Projections.MovieMinProjection;

public class MovieMinDto {

	private Long id;
	private String name;
	
	
	public MovieMinDto() {
	}
	
	public MovieMinDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public MovieMinDto(MovieMinProjection projection) {
		this.id = projection.getId();
		this.name = projection.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MovieMinDto [id=" + id + ", name=" + name + "]";
	}
	
	
}
