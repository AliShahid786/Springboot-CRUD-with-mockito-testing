package com.javatpoint.springbootcrudoperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.javatpoint.error.BooksNotFoundException;
import com.javatpoint.repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.javatpoint.controller.BooksController;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import com.jayway.jsonpath.JsonPath;

import java.util.Optional;

@WebMvcTest(BooksController.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BooksControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BooksService books;

	@Autowired
	private BooksService booksService;
	@Autowired
	private  BooksController booksController;

	@Autowired
	private BooksRepository booksRepository;
	
	private Books book;
	
	@BeforeEach
	void setUp() {
		 book = Books.builder()
				.bookid(2)
				.bookname("som")
				.author("xyz")
				.price(500)
				.build();
		
	}
//	@Test
//	void saveBookTest() throws Exception {
//		Books inputBook = Books.builder()
//				.bookname("som")
//				.author("xyz")
//				.price(500)
//				.build();
//
////		Mockito.when(books.saveOrUpdate(inputBook)).thenReturn(book);
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/book")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{  \r\n"
//        		+ "    \"bookname\": \"do epic shit3\",  \r\n"
//        		+ "    \"author\": \"xyz\",  \r\n"
//        		+ "    \"price\": \"300\"  \r\n"
//        		+ "} ")).andExpect(MockMvcResultMatchers.status().isOk());
//
//	}
	
//	@Test
//	void getBooksByIdTest() throws Exception {
//
////		Mockito.when(books.getBooksById(2)).thenReturn(book);
////		Mockito.when(booksController.getBooks(1)).thenReturn(book);
//
////		mockMvc.perform(MockMvcRequestBuilders.get("/book/2")
////		.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
//
//		assertEquals(booksController.getBooks(1).getBookid(),2);
//	}

//	@Test
//	public void endToEnd() throws BooksNotFoundException {
//		Books books1 = booksController.getBooks(2);
//		assertEquals(books1.getAuthor(),"abc");
//	}
	@Test
	void findByIdTest2() {

		Books found = booksRepository.findById(1).get();
		assertEquals("xyz", found.getAuthor() );

//		Books found = booksRepository.findById(200).get();
//		assertEquals(found.getAuthor(),"ab" );

	}

}
