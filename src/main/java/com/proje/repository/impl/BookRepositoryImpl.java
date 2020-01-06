package com.proje.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.Impl.JpaFactoryImpl;
import com.proje.model.Book;
import com.proje.reporsitory.BookRepository;

public class BookRepositoryImpl implements BookRepository {


	private EntityManager entityManager = jpaFactory.getEntityManager();

	private EntityTransaction transaction = jpaFactory.getEntityTransaction();

	@Override
	public void save(Book book) {
		
		transaction.begin();
		entityManager.persist(book);
		transaction.commit();
	}

	@Override
	public void delete(Book book) {
		this.transaction.begin();
		this.entityManager.remove(book);
		this.transaction.commit();

	}

	@Override
	public Book find(int id) {
		Book book = this.entityManager.find(Book.class, id);
		if (book!=null) {
			return book;
		}
		return null;
	}

	@Override
	public Book update(Book book) {
		
		transaction.begin();
		Book updatedBook = this.entityManager.merge(book);
		transaction.commit();
		
		return updatedBook;
	}

}
