package com.javatpoint.springbootcrudoperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.javatpoint.error.BooksNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import com.javatpoint.service.BooksService;

@SpringBootTest
public class BookServiceTest {
	@Autowired
	BooksService booksService;
	
	@MockBean
	BooksRepository booksRepository;
	
	@BeforeEach
	void setUp() {
		Optional<Books> book = 
				Optional.ofNullable(Books.builder()
		.bookid(100)
		.bookname("your head is houseboat")
		.author("abcd")
		.price(1200)
		.build());
		
		Mockito.when(booksRepository.findById(100)).thenReturn(book); 
	}
	
	@Test
	public void getBooksByIdTest() throws BooksNotFoundException {
		
		Books found = booksService.getBooksById(100);	
		assertEquals("abcd", found.getAuthor());
		
	}

}
