package com.kishan.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8793211644565454943L;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "BOOK_ID")
	private Long bookId;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name="book_id_seq", sequenceName = "BOOK_ID_SEQ", allocationSize = 1)
	@Column(name = "BOOK_ID")
	private Long bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_ISBN_NUMBER")
	private String bookISBN;
	
	@Column (name = "BOOK_PRICE")
	private double bookPrice;
	
	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;	
	
	@ManyToOne(targetEntity = Library.class)
	@JoinColumn(name = "LIBRARY_ID")
	private Library library;

	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	

}
