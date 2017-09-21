package adcorps.io.backend.service;

/*This interface implements Movie service methods to allow listing of movies based on conditions.*/

import java.util.List;
import adcorps.io.backend.entity.Movie;

public interface MovieService {
	
	//List All Movies
	public List<Movie> findAll();
	
	//Find Movies by ID
	public Movie findById(String movieId);
	
	//Create Movie
	public Movie create(Movie movie);
	
	//Update Movie info based on Movie ID
	public Movie update(String movieId, Movie movie);
	
	//Delete a movie data based on ID
	public void delete(String movieId);

}
