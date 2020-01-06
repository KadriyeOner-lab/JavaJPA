package com.proje.test;

import java.util.Calendar;
import java.util.Date;

import com.proje.model.Book;
import com.proje.reporsitory.BookRepository;
import com.proje.repository.impl.BookRepositoryImpl;

public class TestPersist {
	
	public static void main(String[] args) {
		
		BookRepository bookRepository = new BookRepositoryImpl();
		
		
		
		Book book1 = new Book(100, "Harry Potter", 350, "Aksiyon-Macera", "Hogward", createCustomDate(25, 10, 1996));
	
		Book book2 = new Book(101, "Harry Potter2", 490, "Aksiyon-Macera", "Kadriye", createCustomDate(01, 9, 1999));
		
		
		Book book3 = new Book(102, "Þeker Portakalý", 210, "Otobiyografik Kurgu", "José Mauro de Vasconcelos", createCustomDate(01, 2, 1968));
		Book book4 = new Book(103, "Güneþi Uyandýralým", 350, "Otobiyografik Kurgu", "José Mauro de Vasconcelos", createCustomDate(10, 10, 1970));
		Book book5 = new Book(104, "Delifiþek", 350, "Otobiyografik Kurgu", "José Mauro de Vasconcelos", createCustomDate(25, 8, 1971));
		
		bookRepository.save(book1);
	bookRepository.save(book2);
	bookRepository.save(book3);
	bookRepository.save(book4);
	bookRepository.save(book5);
	}
	
	public static Date createCustomDate(int day, int month, int year) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,  day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		
		return calendar.getTime();
		
	}

}
