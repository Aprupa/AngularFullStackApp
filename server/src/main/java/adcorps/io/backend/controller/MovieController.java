package adcorps.io.backend.controller;

/*This class controls the mapping of CRUD functions for Movies.*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adcorps.io.backend.entity.Movie;
import adcorps.io.backend.service.MovieService;

//Rest Controller
@RestController
@RequestMapping(value="/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@Autowired
	MovieService service;
	
	//Maps to Get function to retrieve data and show it on front end
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	//Maps the Get function to retrieve data and show it on front end based on the ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Movie findById(@PathVariable("id") String movieId){
		return service.findById(movieId);
	}
	
	//Maps the POST function to allow admin to create movie data.
	@RequestMapping(value = "/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
	}
	
	//Maps the Put method to allow admin update any move based on id.
	@RequestMapping(method = RequestMethod.PUT, value = "/admin/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie){
		return service.update(movieId, movie);	
	}
	
	//Maps the Delete function to allow admin to delete any move based on id 
	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/{id}")
	public void delete(@PathVariable("id") String movieId){
		service.delete(movieId);
	}
}
