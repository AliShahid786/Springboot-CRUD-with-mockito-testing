package com.javatpoint.springbootcrudoperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.print.Book;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
//	@BeforeEach
//	void setUp() {
//		Books book =Books.builder()
//		.bookid(200)
//		.bookname("your head is houseboat")
//		.author("ab")
//		.price(1200)
//		.color("red")
//		.build();
//	
//		entityManager.persist(book);	
//	}
	@Test
	void findByIdTest() {

		Books found = booksRepository.findById(1).get();
		assertEquals("xyz", found.getAuthor() );
		
//		Books found = booksRepository.findById(200).get();
//		assertEquals(found.getAuthor(),"ab" );
		
	}
	

}
