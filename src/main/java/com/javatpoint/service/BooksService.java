package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import com.javapoint.error.BooksNotFoundException;
import com.javatpoint.error.BooksNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

//defining the business logic  
@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    //getting all books record by using the method findaAll() of CrudRepository
    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Books getBooksById(int id) throws BooksNotFoundException {
		System.out.println("in service");
        Optional<Books> books = booksRepository.findById(id);

		if(!books.isPresent()){
            System.out.println("inside method");
			throw new BooksNotFoundException("Books not Available");
		}
		return books.get();
    }

//    public Books getBooksById(int id) throws BooksNotFoundException {
//
//		return booksRepository.findById(id).orElse(null);
//    }

    //saving a specific record by using the method save() of CrudRepository
    public Books saveOrUpdate(Books books) {
        booksRepository.save(books);
        return books;
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Books books, int bookid) {
        booksRepository.save(books);
    }
}