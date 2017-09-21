package adcorps.io.backend.service;

/* This is the implementation of Movie Service to perform CRUD operations for Movie. */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adcorps.io.backend.entity.Movie;
import adcorps.io.backend.exception.MovieAlreadyExistException;
import adcorps.io.backend.exception.MovieNotFoundException;
import adcorps.io.backend.repository.MovieRepository;

//Service Annotation.
@Service
public class MovieServiceImplementation implements MovieService {
	
	//Autowiring Object instance
	@Autowired
	MovieRepository repository;
	
	//Finds All movies
	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	//Finds movie by ID
	@Override
	public Movie findById(String movieId) {
		// TODO Auto-generated method stub
		Movie movie = repository.findMovieById(movieId);
		if(movie == null){
			throw new MovieNotFoundException("Movie with given ID not found : " +movieId);
		}
		return movie;
	}

	//Creates new movie data.New Transaction created
	@Override
	@Transactional
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		
		Movie existing = repository.findMovieByImdbID(movie.getImdbID());
		if(existing != null){
			throw new MovieAlreadyExistException("Movie already exist with imdbID="+movie.getImdbID());
		}
		return repository.create(movie);
	}
	
	//Updates a movie in db, New Transaction created. 
	@Transactional
	@Override
	public Movie update(String movieId, Movie movie) {
		// TODO Auto-generated method stub
		Movie existing = repository.findMovieById(movieId);
		if(existing == null){
			throw new MovieNotFoundException("Movie not found with movieId="+movieId);
		}
		return repository.update(movie);
	}
	
	//Deletes Movie from DB, creates a transaction
	@Transactional
	@Override
	public void delete(String movieId) {
		// TODO Auto-generated method stub
		Movie existing = repository.findMovieById(movieId);
		if(existing == null){
			throw new MovieNotFoundException("Movie not found with movieId="+movieId);
		}
		repository.delete(existing);
		
	}
	
	

}
