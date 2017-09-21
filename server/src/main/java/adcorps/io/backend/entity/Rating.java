package adcorps.io.backend.entity;

/* This entity class allows you to register your rating for a particular movie.*/

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findByMovieId", query = "Select r from Rating r where r.movie.movieID = :id")
})
public class Rating {

	
	@Id
	private String ratingID;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;
	
	public Rating(){
		ratingID = UUID.randomUUID().toString();
	}
	
	public String getRatingID() {
		return ratingID;
	}
	public void setRatingID(String ratingID) {
		this.ratingID = ratingID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
