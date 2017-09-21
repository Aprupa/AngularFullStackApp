package adcorps.io.backend.repository;

/*Implementation of Rating. used to update Ratings in db*/

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import adcorps.io.backend.entity.Rating;

@Repository
public class RatingRepositoryImplementation implements RatingRepository {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Rating> findRatingByMovie(String movieID) {
		// TODO Auto-generated method stub
		
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByMovieId",Rating.class);
		query.setParameter("id", movieID);
		return query.getResultList();
	}

	@Override
	public Rating findByID(String ratingID) {
		// TODO Auto-generated method stub
		return em.find(Rating.class, ratingID);
	}

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		em.persist(rating);
		return rating;
	}

	@Override
	public Rating update(Rating existingRating) {
		// TODO Auto-generated method stub
		return em.merge(existingRating);
	}

	@Override
	public void delete(Rating existingRating) {
		// TODO Auto-generated method stub
		em.detach(existingRating);
	}

}
