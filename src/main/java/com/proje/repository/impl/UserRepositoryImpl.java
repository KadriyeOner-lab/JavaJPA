package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;



import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private EntityManager entityManager = entityFactory.getEntityManager();
	private EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public boolean saveUser(final User user) {
		try {

			this.transaction.begin();
			this.entityManager.persist(user);
			this.transaction.commit();

		} catch (RuntimeException e) {
			System.err.println("Hata: " + e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println("Hata: " + e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(final User user) {
		try {

			this.transaction.begin();
			this.entityManager.merge(user);
			this.entityManager.flush();
			this.transaction.commit();

		} catch (RuntimeException e) {
			System.err.println("Hata: " + e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println("Hata: " + e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean removeUser(final User user) {
		try {

			if (this.entityManager.contains(user)) {
				this.entityManager.remove(user);
			} else {
				User deleteUser = this.findById(user.getUserId());
				this.entityManager.remove(deleteUser);
			}

		} catch (RuntimeException e) {
			System.err.println("Hata: " + e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println("Hata: " + e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public User findById( final Integer id) {
		User user = null;
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);

			typedQuery.setParameter("userId", id);
			user = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println("User bulunamadý..Hata: " + e);
		}

		return user;
	}

	@Override
	public User findByUsername(final String username) {

		User user = null;
		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
			typedQuery.setParameter("username", username);
			user = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println("User bulunamadý..Hata: " + e);
		}
		return user;
	}

	@Override
	public User findWithUserDetailByUserName(final String username) {
		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername",
					User.class);
			typedQuery.setParameter("User.findWithUserDetailByUsername", username);
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.err.println("User bulunamadý..Hata: " + e);
		}
		return user;
	}

	@Override
	public List<User> findUsers() {
		List<User> users = null;
try {
	
	TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
	users = typedQuery.getResultList();
	
} catch (NoResultException e) {
	System.err.println("User bulunamadý..Hata: " + e);
}
		return users;
	}

	@Override
	public List<User> findUser(int firstResult, int maxResult) {
		List<User> users = null;
		try {
			
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			users = typedQuery.getResultList();
			
			
		} catch (NoResultException e) {
			System.err.println("User bulunamadý..Hata: " + e);
		}
				return users;
	}

	@Override
	public int findUserCount() {
		int count=0;
		
		try {
			TypedQuery<Integer> typedQuery = (TypedQuery<Integer>) this.entityManager.createNamedQuery("User.findUsers", Integer.class);
			
	count =(int)typedQuery.getSingleResult();
		} catch (RuntimeException e) {
			System.err.println("Hata: " +e);
		}
		return count;
	}

	@Override
	public UserInfo findUserInfoByUsername(final String username) {
		UserInfo userInfo=null;
		
		try {
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.findUSerInfoByUserName", UserInfo.class);
			typedQuery.setParameter("username", username);
			userInfo=typedQuery.getSingleResult();						
			
		} catch (NoResultException e) {
			System.err.println("User bulunamadý..Hata: " + e);
		}
		
		return userInfo;
	}

}
