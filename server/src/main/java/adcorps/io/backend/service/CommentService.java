package adcorps.io.backend.service;

/* Interface implementation for Comments on a particular movie*/

import java.util.List;
import adcorps.io.backend.entity.Comment;


public interface CommentService {
	
	//Listing all comments
	public List<Comment> findCommentByMovie(String movieID);
	
	//Find Comments by ID
	public Comment findById(String commentId);
	
	//Create comments for movie
	public Comment create(Comment comment);
	
	//Update comments based on comment ID
	public Comment update(String commentId, Comment comment);
	
	//Delete comments based on commentID
	public void delete(String commentID);
	

}
