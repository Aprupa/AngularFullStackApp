package adcorps.io.backend.repository;

/* This interface will work on the */
import java.util.List;
import adcorps.io.backend.entity.User;

public interface UserRepository {
	
	//List all users in DB
	public List <User> findAll();
	
	//List Users by UsersID
	public User findById(String userId);
	
	//List users by Email
	public User findByEmail(String userEmail);
	
	//Create new User
	public User create(User user);
	
	//Update existing user
	public User update(User existingUser);
	
	//Delete existing user
	public void delete(User existingUser);
}
