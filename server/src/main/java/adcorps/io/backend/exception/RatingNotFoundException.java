package adcorps.io.backend.exception;

/* This is an exception class thrown at runtime when Rating is not found */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status thrown on front-end
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RatingNotFoundException extends RuntimeException {
	
	//System Generated Serial number
	private static final long serialVersionUID = -8583507350723957385L;
	//Parameterized Constructor for Message

	public RatingNotFoundException(String message){
		super(message);
	}
}
