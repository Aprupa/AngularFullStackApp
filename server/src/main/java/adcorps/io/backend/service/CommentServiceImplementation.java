package adcorps.io.backend.service;

/*This is an implementation of Comment Service, to allow the CRUD operations on Comments for movies. */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adcorps.io.backend.entity.Comment;
import adcorps.io.backend.exception.CommentNotFoundException;
import adcorps.io.backend.repository.CommentRepository;

//Service
@Service
public class CommentServiceImplementation implements CommentService {
	
	//Autowiring of Object
	@Autowired
	CommentRepository repository;
	
	//Finds Comment by Movie
	@Override
	public List<Comment> findCommentByMovie(String movieID) {
		// TODO Auto-generated method stub
		return repository.findCommentByMovie(movieID);
	}
	
	//Finds Comment by ID
	@Override
	public Comment findById(String commentId) {
		// TODO Auto-generated method stub
		Comment comment = repository.findById(commentId);
		if(comment == null){
			throw new CommentNotFoundException("Comment Not found for give id :  " +commentId);
		}
		return comment;
	}
	
	//Create Comment for movie, Transaction created.
	@Transactional
	@Override
	public Comment create(Comment comment) {
		// TODO Auto-generated method stub
		return repository.create(comment);
	}
	
	//Updates a comment, Transaction Created
	@Transactional
	@Override
	public Comment update(String commentId, Comment comment) {
		// TODO Auto-generated method stub
		
		Comment existing = repository.findById(commentId);
		if(existing == null){
			throw new CommentNotFoundException("Comment Not found for given id : " +commentId);
		}
		return repository.update(comment);
	}
	
	//Deletes A movie, transaction created
	@Transactional
	@Override
	public void delete(String commentID) {
		// TODO Auto-generated method stub
		
		Comment existing = repository.findById(commentID);
		if(existing == null){
			throw new CommentNotFoundException("Comment not found with id="+commentID);
		}
		repository.delete(existing);
	}

}
