package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.Projections.MovieMinProjection;
import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "select movies.id , movies.name from movies inner join genres on movies.id_genres = genres.id where genres.description = :name")
	List<MovieMinProjection> search1(String name);
	
	@Query("select new com.devsuperior.uri2611.dto.MovieMinDto(obj.id, obj.name)"
			+ " from Movie obj"
			+ " where obj.genre.description = :name")
	List<MovieMinDto> search2(String name);
}
