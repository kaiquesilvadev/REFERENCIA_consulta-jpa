package com.devsuperior.uri2611;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.Projections.MovieMinProjection;
import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 List<MovieMinProjection> list = movieRepository.search1("Action");
		 list.stream().map(movie -> new MovieMinDto(movie)).forEach(x ->  System.out.println(x));
		 
		 List<MovieMinDto> list2 = movieRepository.search2("Action");
		 list2.stream().forEach(x ->  System.out.println(x));
		 
	}
}
