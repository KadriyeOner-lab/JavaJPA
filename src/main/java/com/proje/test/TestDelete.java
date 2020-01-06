package com.proje.test;

import com.proje.model.Book;
import com.proje.reporsitory.BookRepository;
import com.proje.repository.impl.BookRepositoryImpl;

public class TestDelete {

public static void main(String[] args) {
		
		
		BookRepository bookRepository = new BookRepositoryImpl();
		
		Book book = bookRepository.find(100);
		
		bookRepository.delete(book);
		
	}
}
