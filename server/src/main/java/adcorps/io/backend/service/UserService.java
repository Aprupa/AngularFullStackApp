package adcorps.io.backend.service;

/*This interface allows storing User data, and perform query on based on user ID.*/

import adcorps.io.backend.entity.User;
import java.util.List;

public interface UserService {

	//Find All Users
	public List<User> findAll();
	
	//Find User based on ID
	public User findById(String userId);
	
	//Create User.
	public User create(User user);
	
	//Update user data.
	public User update(String userId, User user);
	
	//delete user data from DB
	public void remove(String userId);	
	
}
