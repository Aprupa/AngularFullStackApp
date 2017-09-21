package adcorps.io.backend.service;

/*Implementation of User Service, to allow performing CRUD operations for User data. */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adcorps.io.backend.entity.User;
import adcorps.io.backend.exception.*;
import adcorps.io.backend.repository.UserRepository;

//Service annotation
@Service
public class UserServiceImplementation implements UserService {

	//Autowiring the object
	@Autowired
	private UserRepository repository;
	
	//Find All users
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	//Find user by ID
	@Override
	public User findById(String userId) {
		// TODO Auto-generated method stub
		User user = repository.findById(userId);
		if(user == null){
			throw new UserNotFoundException("User not found with id : " + userId);
		}
		return user;
	}
	
	//Create new User, creates a transaction
	@Transactional	
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			throw new UserAlreadyExistException("User Already Exists with this email" + user.getEmail());
		}
		return repository.create(user);		
	}
	
	//Updates Existing User, creates a transaction
	@Transactional
	@Override
	public User update(String userId, User user) {
		// TODO Auto-generated method stub
		User existing = repository.findById(userId);
		if(existing == null){
			throw new UserNotFoundException("User not found with id="+userId);
		}
		return repository.update(user);
	}
	
	//Deletes existing User, creates a transaction.
	@Transactional
	@Override
	public void remove(String userId) {
		// TODO Auto-generated method stub
		User existing = repository.findById(userId);
		if(existing == null){
			throw new UserNotFoundException("User not found with id="+userId);
		}
		repository.delete(existing);
	}

}
