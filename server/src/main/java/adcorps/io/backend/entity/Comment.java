package adcorps.io.backend.entity;
/*Comment entity class, that allows you to register a comment for a particular movie */

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




//Allows us to create Entity, Table and Named Queries. 
@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Comment.findByMovieId", query = "Select c from Comment c where c.movie.movieID = :id")
})
public class Comment {
	
	@Id
	private String cmntID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@Column(columnDefinition="TEXT")
	private String comment;
	
	public Comment(){
		cmntID = UUID.randomUUID().toString();
	}
	
	
	//Getter and Setter Methods.
	public String getCmntID() {
		return cmntID;
	}
	public void setCmntID(String cmntID) {
		this.cmntID = cmntID;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
