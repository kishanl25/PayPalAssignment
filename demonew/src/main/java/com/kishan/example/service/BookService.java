package com.kishan.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.kishan.example.dao.BookDAO;
import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;
import com.kishan.example.model.BookModel;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDao;
	
	public List<Book> getBookByLibrary(Library library){
		return this.bookDao.getBooksByLibrary(library);		
	}
	
	public List<Book> getAllBooks(){
		return this.bookDao.findAll();
	}
	
	public Book saveBook(Book bookObj){
		Book book = this.bookDao.save(bookObj);
		return book;		
	}
	
	public boolean deleteBook(Book bookObj){
		this.bookDao.delete(bookObj);
		return true;
	}
	
	public Iterable<Book> getBooksByLibrary(Library library){
		return this.bookDao.findBookByLibrary(library.getLibraryId());
	}
	
	/*public void saveBookJSON(String bookJSON){
		Book bookObj = new Book();
		bookObj.setBookName(book.getBookName());
		bookObj.setBookISBN(book.getBookISBN());
		bookObj.setBookPrice(book.getBookPrice());
		bookObj.setBookAuthor(book.getBookAuthor());
		this.bookDao.save(bookObj);		
	}*/

}
