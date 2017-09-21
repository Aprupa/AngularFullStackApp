package adcorps.io.backend.repository;

/* This interface will be implemented to work on an existing Rating in DB */

import java.util.List;
import adcorps.io.backend.entity.Rating;

public interface RatingRepository {
	
	//Finds Rating by Movie ID
	public List<Rating> findRatingByMovie(String movieID);

	//find movie rating ID
	public Rating findByID(String ratingID);
	
	//Create New Rating
	public Rating create(Rating rating);
	
	//Update Existing Rating
	public Rating update(Rating existingRating);
	
	//Delete Rating
	public void delete(Rating existingRating);
	
}
