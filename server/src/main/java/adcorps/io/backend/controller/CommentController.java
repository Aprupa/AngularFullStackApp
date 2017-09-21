package adcorps.io.backend.controller;

/* Comment Controller class, controls the REST methods for interaction with front end */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adcorps.io.backend.entity.Comment;
import adcorps.io.backend.service.CommentService;

//Makes it a Rest Controller
@RestController
public class CommentController {
	
	@Autowired
	CommentService service;
	
	//Maps it to GET method to retrieve data. 
	@RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findCommentByMovie(@PathVariable("movieId") String movieId){
		return service.findCommentByMovie(movieId);
	}
	
	//Maps to get method to retrieve data
	@RequestMapping(method = RequestMethod.GET, value = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment findById(@PathVariable("id") String commentId){
		return service.findById(commentId);
	}
	
	//Maps to Post method to create comment
	@RequestMapping(method = RequestMethod.POST, value = "/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment createComment(@RequestBody Comment comment){
		return service.create(comment);
	}
	
	//Maps to PUT method, which will update the comment.
	@RequestMapping(method = RequestMethod.PUT, path = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment updateComment(@PathVariable("id") String commentId, @RequestBody Comment comment){
		return service.update(commentId, comment);
	}
	
	//Maps to Delete method, to delete the comment
	@RequestMapping(method = RequestMethod.DELETE, path = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteComment(@PathVariable("id") String commentId) {
		service.delete(commentId);
	}


}
