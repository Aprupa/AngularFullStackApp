package adcorps.io.backend.service;

/*This is the implementation of Rating Service to per */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adcorps.io.backend.entity.Rating;
import adcorps.io.backend.exception.RatingNotFoundException;
import adcorps.io.backend.repository.RatingRepository;

@Service
public class RatingServiceImplementation implements RatingService {
	
	@Autowired
	RatingRepository repository;

	@Override
	public List<Rating> findRatingByMovie(String movieID) {
		// TODO Auto-generated method stub
		return repository.findRatingByMovie(movieID);		
	}

	@Override
	public Rating findById(String ratingId) {
		// TODO Auto-generated method stub
		Rating rating = repository.findByID(ratingId);
		if(rating ==  null){
			throw new RatingNotFoundException("Rating not found : "+ratingId);
		}
		return rating;
	}
	@Transactional
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return repository.create(rating);
	}

	@Transactional
	@Override
	public Rating update(String ratingId, Rating rating) {
		// TODO Auto-generated method stub
		Rating existing = repository.findByID(ratingId);
		if(existing == null){
			throw new RatingNotFoundException("Raitng for Id : " + ratingId + " not found");
		}
		
		return repository.update(rating);
	}

	@Override
	public void delete(String ratingId) {
		// TODO Auto-generated method stub
		Rating existing = repository.findByID(ratingId);
		if(existing == null){
			throw new RatingNotFoundException("Rating not found with id="+ratingId);
		}
		repository.delete(existing);		
	}

}
