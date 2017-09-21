package adcorps.io.backend.exception;

/*This exception is thrown when Movie is not found. This will be thrown */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status shown on front-end
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
	
	//System Generated Serial Version.
	private static final long serialVersionUID = -8583507350723957385L;
	//Parameterized Constructor for Message

	public MovieNotFoundException(String message){
		super(message);
	}
}
