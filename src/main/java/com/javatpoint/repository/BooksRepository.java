package com.javatpoint.repository;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;  
import com.javatpoint.model.Books;  
//repository that extends CrudRepository  
public interface BooksRepository extends JpaRepository<Books, Integer>  
{  
} 