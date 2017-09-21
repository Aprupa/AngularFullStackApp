package adcorps.io.backend.exception;

/* This is an exception thrown when Movie already exists in DB */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status thrown at Front-end
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieAlreadyExistException extends RuntimeException {
	
	//System Generated Exception
	private static final long serialVersionUID = -759468624671133790L;
	//Parameterized Constructor for Message
	public MovieAlreadyExistException(String message){
		super(message);
	}
}
