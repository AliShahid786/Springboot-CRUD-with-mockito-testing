package com.javatpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//mark class as an Entity   
@Entity
//defining class name as Table name  
@Table(name="books")
public class Books {
//Defining book id as primary key  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookid")
	private int bookid;
	@Column(name="bookname")
	private String bookname;
	@Column(name="author")
	private String author;
	@Column(name="price")
	private int price;
	@Column(name="color")
	private String color;
//	public Books(int bookid, String bookname, String author, int price, String color) {
//		super();
//		this.bookid = bookid;
//		this.bookname = bookname;
//		this.author = author;
//		this.price = price;
//		this.color = color;
//	}
	

}
