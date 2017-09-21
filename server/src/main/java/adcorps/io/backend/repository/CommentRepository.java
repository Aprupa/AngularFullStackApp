package adcorps.io.backend.repository;

/*Comment Repository Interface, will be implemented in Comment Repository class, for comments on movie for updating existing comment. */

import java.util.List;
import adcorps.io.backend.entity.Comment;

public interface CommentRepository {

	//Finds Comment by movie Id
	public List<Comment> findCommentByMovie(String movieId);

	//Finds Comment by comment ID
	public Comment findById(String commentId);
	
	//creates a new comment
	public Comment create(Comment comment);
	
	//Updates an existing comment
	public Comment update(Comment existingComment);
	
	//deletes an existing comment
	public void delete(Comment existingComment);
}