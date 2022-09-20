package com.javatpoint.springbootcrudoperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.javatpoint.controller.BooksController;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import com.jayway.jsonpath.JsonPath;

@WebMvcTest(BooksController.class)
public class BooksControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BooksService books;
	
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
	@Test
	void saveBookTest() throws Exception {
		Books inputBook = Books.builder()
				.bookname("som")
				.author("xyz")
				.price(500)
				.build();
		
		Mockito.when(books.saveOrUpdate(inputBook)).thenReturn(book);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{  \r\n"
        		+ "    \"bookname\": \"do epic shit3\",  \r\n"
        		+ "    \"author\": \"xyz\",  \r\n"
        		+ "    \"price\": \"300\"  \r\n"
        		+ "} ")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	void getBooksByIdTest() throws Exception {
		
		Mockito.when(books.getBooksById(2)).thenReturn(book);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/book/2")
		.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
}
