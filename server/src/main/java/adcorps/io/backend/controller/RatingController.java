package adcorps.io.backend.controller;

/*This class works for Ratings and performs CRUD operations for Ratings*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adcorps.io.backend.entity.Rating;
import adcorps.io.backend.service.RatingService;

//Controller Annotation to make this class behave as REST controller
@RestController
public class RatingController {
	
	//Auto wiring
	@Autowired
	RatingService service;

	//Mapping the GET function to retrieve the rating.
	@RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findRatingByMovie(@PathVariable("movieId") String movieId){
		return service.findRatingByMovie(movieId);
	}
	
	//Mapping the GET function to retrieve the rating based on ID
	@RequestMapping(method = RequestMethod.GET, value = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findById(@PathVariable("id") String ratingId){
		return service.findById(ratingId);
	}
	
	//Mapping the POST function to create the Rating for a movie.
	@RequestMapping(method = RequestMethod.POST, value = "/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating createRating(@RequestBody Rating rating){
		return service.create(rating);
	}
	
	//Mapping the Put method to update a particular request.
	@RequestMapping(method = RequestMethod.PUT, path = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating updateRating(@PathVariable("id") String ratingId, @RequestBody Rating rating){
		return service.update(ratingId, rating);
	}
	
	//Mapping delete to remove rating for a movie.
	@RequestMapping(method = RequestMethod.DELETE, path = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteRating(@PathVariable("id") String ratingId) {
		service.delete(ratingId);
	}

}
