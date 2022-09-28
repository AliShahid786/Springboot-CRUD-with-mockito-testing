package com.javatpoint.controller;

import java.util.List;

//import com.javapoint.error.BooksNotFoundException;
import com.javatpoint.error.BooksNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;

//mark class as Controller  
@RestController
public class BooksController {

//autowire the BooksService class  
	@Autowired
	BooksService booksService;
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(BooksController.class);

//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping(value = "books")
	private List<Books> getAllBooks() {
		logger.info("inside of getAllBooks method");
		return booksService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book  
//	@GetMapping("/book/{bookid}")
//	private ResponseEntity<Books> getBooks(@PathVariable("bookid") int bookid) throws BooksNotFoundException {
//		Books books = booksService.getBooksById(bookid);
//		if (booksService.getBooksById(bookid) == null)
//			return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(books, HttpStatus.OK);
//	}

	@GetMapping("/book/{bookid}")
	public Books getBooks(@PathVariable("bookid") int bookid) throws BooksNotFoundException {

		return booksService.getBooksById(bookid);
	}

//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {

		booksService.delete(bookid);
	}

//creating post mapping that post the book detail in the database  
	@PostMapping("/book")
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

//creating put mapping that updates the book detail   
	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}

}
