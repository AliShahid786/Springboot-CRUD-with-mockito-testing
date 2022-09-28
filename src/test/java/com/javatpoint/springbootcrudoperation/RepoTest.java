package com.javatpoint.springbootcrudoperation;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepoTest {
    @Autowired
    BooksRepository booksRepository;
    @Test
    public void findByIdTest(){
//        Books books = new Books(111,"sss", "hfm", 400, "red");
		Books book =Books.builder()
		.bookid(200)
		.bookname("your head is houseboat")
		.author("ab")
		.price(1200)
		.color("red")
		.build();
        booksRepository.save(book);
        Boolean exitstOrNot = booksRepository.existsById(111);
        assertEquals(exitstOrNot,Boolean.TRUE );

    }
    @AfterEach
    public void aftereach(){
        booksRepository.deleteById(200);
    }



}
