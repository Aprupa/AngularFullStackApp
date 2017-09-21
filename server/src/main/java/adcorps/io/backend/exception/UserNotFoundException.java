package adcorps.io.backend.exception;

/* This is user not found Runtime exception. Thrown when user is not found*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This is the HTTP Status which will come on front-end
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	//System Generated Serial Number
	private static final long serialVersionUID = -8583507350723957385L;
	//Parameterized Constructor for Message

	public UserNotFoundException(String message){
		super(message);
	}
}
