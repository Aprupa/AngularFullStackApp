package adcorps.io.backend.repository;

/* This is implementation of Movie Repository. It allows the user to perform CRUD operations on Movie Database. */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import adcorps.io.backend.entity.Movie;

//Creating the Repository Class
@Repository
public class MovieRepositoryImplementation implements MovieRepository {

	//Creating the Persistence Context
	@PersistenceContext
	private EntityManager em;
	
	//Find All Movies
	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		TypedQuery <Movie> query = em.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
	}
	
	//Find By Movie ID
	@Override
	public Movie findMovieById(String movieID) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, movieID);
	}
	
	//Find By IMDB ID
	@Override
	public Movie findMovieByImdbID(String ImdbId) {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByImdbId", Movie.class);
		query.setParameter("imdbID", ImdbId);
		List<Movie> movie = query.getResultList();
		if(movie.size() == 1){
			return movie.get(0);
		}
		else {
			return null;
		}
	}
	
	//Create New Movie
	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		em.persist(movie);
		return movie;
	}
	
	//Update Movie
	@Override
	public Movie update(Movie existingMovie) {
		// TODO Auto-generated method stub
		return em.merge(existingMovie);
	}
	
	//Delete Movie
	@Override
	public void delete(Movie existingMovie) {
		// TODO Auto-generated method stub
		em.remove(existingMovie);
	}

}
