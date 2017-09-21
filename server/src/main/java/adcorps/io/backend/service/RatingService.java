package adcorps.io.backend.service;

/*This interface implementation allows user to create, update , find and delete movie Ratings.*/

import java.util.List;
import adcorps.io.backend.entity.Rating;

public interface RatingService {

	//Listing Rating By Movie
	public List<Rating> findRatingByMovie(String movieID);
	
	//Listing Rating by Id
	public Rating findById(String ratingId);
	
	//Create Rating
	public Rating create(Rating rating);
	
	//Update Rating
	public Rating update(String ratingId, Rating rating);
	
	//Delete Rating
	public void delete(String ratingId);
	
}
