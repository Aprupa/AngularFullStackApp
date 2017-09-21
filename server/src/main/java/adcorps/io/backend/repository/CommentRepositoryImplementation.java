package adcorps.io.backend.repository;

/* This is the implementation of Comment Repository interface, to query, and perform CRUD operations on Comment of a movie*/

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import adcorps.io.backend.entity.Comment;

//Making this class as repository for Spring.
@Repository
public class CommentRepositoryImplementation implements CommentRepository {

	//Making the object as Persistence Context
	@PersistenceContext
	private EntityManager em;
	
	//Finding Comment by Movie
	@Override
	public List<Comment> findCommentByMovie(String movieId) {
		TypedQuery <Comment> query = em.createQuery("Comment.findByMovieId", Comment.class);
		query.setParameter("id", movieId);
		return query.getResultList();
	}
	
	//Finding Comment by comment ID
	@Override
	public Comment findById(String commentId) {
		// TODO Auto-generated method stub
		return em.find(Comment.class, commentId);
	}

	//Using persistence to create new Comment.
	@Override
	public Comment create(Comment comment) {
		// TODO Auto-generated method stub
		em.persist(comment);
		return comment;
	}
	
	//Using merge to update an existing comment
	@Override
	public Comment update(Comment existingComment) {
		// TODO Auto-generated method stub
		return em.merge(existingComment);
	}
	
	//using remove to delete comment.
	@Override
	public void delete(Comment existingComment) {
		// TODO Auto-generated method stub
		em.remove(existingComment);
		
	}
	
	

}
