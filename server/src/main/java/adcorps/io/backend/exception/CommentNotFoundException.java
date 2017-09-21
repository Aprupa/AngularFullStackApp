package adcorps.io.backend.exception;

/*This exception is thrown at runtime when Comment is not found */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP response status thrown on front-end
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException {
	
	//System Generated serial number
	private static final long serialVersionUID = -8583507350723957385L;
	//Parameterized Constructor for Message
	public CommentNotFoundException(String message){
		super(message);
	}
}
