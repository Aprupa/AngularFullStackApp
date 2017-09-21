package adcorps.io.backend.exception;

/*This exception is thrown at Runtime when user already exists in database*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status code thrown on front-end
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExistException extends RuntimeException {
	
	//System Generated Serial Number
	private static final long serialVersionUID = -759468624671133790L;
	//Parameterized Constructor for Message

	public UserAlreadyExistException(String message){
		super(message);
	}
}
