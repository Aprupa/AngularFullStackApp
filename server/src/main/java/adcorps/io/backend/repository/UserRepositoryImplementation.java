package adcorps.io.backend.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import adcorps.io.backend.entity.User;

@Repository
public class UserRepositoryImplementation implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		TypedQuery <User> query = em.createNamedQuery("User.findAll",User.class);
		return query.getResultList();
	}

	@Override
	public User findById(String userId) {
		// TODO Auto-generated method stub
		return em.find(User.class, userId);
	}

	@Override
	public User findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		TypedQuery <User> query = em.createNamedQuery("User.findByEmail",User.class);
		query.setParameter("email",userEmail);
		List <User> user = query.getResultList();
		if(user.size() == 1){
			return user.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public User update(User existingUser) {
		// TODO Auto-generated method stub
		return em.merge(existingUser);
	}

	@Override
	public void delete(User existingUser) {
		// TODO Auto-generated method stub
		em.remove(existingUser);
	}

}
