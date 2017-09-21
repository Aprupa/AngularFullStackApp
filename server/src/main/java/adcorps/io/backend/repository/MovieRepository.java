package adcorps.io.backend.repository;

/* This interface will be implemented for movie respository in database*/

import adcorps.io.backend.entity.Movie;
import java.util.List;

public interface MovieRepository {
	
	//Finds All movies
	public List<Movie> findAll();
	
	//Find Movie by movieID
	public Movie findMovieById(String movieID);
	
	//Find Movie by ImdbID
	public Movie findMovieByImdbID(String ImdbId);
	
	//Create New Movie data
	public Movie create(Movie movie);
	
	//Update existing movie
	public Movie update(Movie existingMovie);
	
	//Delete Existing Movie
	public void delete(Movie existingMovie);

}
