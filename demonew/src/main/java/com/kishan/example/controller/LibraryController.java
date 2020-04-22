package com.kishan.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;
import com.kishan.example.model.BookModel;
import com.kishan.example.model.LibraryModel;
import com.kishan.example.service.BookService;
import com.kishan.example.service.LibraryService;

@RestController
@RequestMapping(path="/library")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping(path = "/libraries")
    @ResponseBody
	public List<LibraryModel> getLibraries(){
		List<LibraryModel> libraryNameList = new ArrayList<LibraryModel>();
		List<Library> libraryList = libraryService.getAllLibraries();
		for (Library lib : libraryList) {
			LibraryModel libraryModel = new LibraryModel();
			System.out.println(lib.getLibraryName());
			libraryModel.setLibraryId(lib.getLibraryId());
			libraryModel.setLibraryName(lib.getLibraryName());
			libraryNameList.add(libraryModel);
		}
		return libraryNameList;
	}	
	
	@GetMapping(path = "/books")
    @ResponseBody
	public List<BookModel> getAllBooks(){
		List<Book> bookList = bookService.getAllBooks();
		List<BookModel> bookModelList = new ArrayList<BookModel>();
		for (Book book : bookList) {
			System.out.println(book.getBookName());
				 BookModel bookModel = new BookModel();
				 bookModel.setBookId(book.getBookId());
				 bookModel.setBookName(book.getBookName());
				 bookModel.setBookISBN(book.getBookISBN());
				 bookModel.setBookPrice(book.getBookPrice());
				 bookModel.setBookAuthor(book.getBookAuthor());
				 bookModelList.add(bookModel);
			 }		
		return bookModelList;
	}	
	 
	 @RequestMapping(value= "/addLibrary", method=RequestMethod.POST)
	    public String addLibrary(@RequestBody Library library) 
	    {
	        libraryService.saveLibrary(library);
			return "Successful";	         
	        	         
	    }
	 
	 @RequestMapping(value= "/addBook", method=RequestMethod.POST, consumes = "application/json")
	    public String addBook(@RequestBody Book book)
	 {
	        bookService.saveBook(book);
			return "Successful";	         
	        	         
	    }
	 @GetMapping(path = "/books", produces = "application/json")
	    @ResponseBody
		public List<Book> getAllBooksFromDB(){
			List<Book> bookList = bookService.getAllBooks();
			for (Book book : bookList) {
				System.out.println(book.getBookName());
			}
			return bookList;
		}
	 
	 @RequestMapping(value= "/getBooksByLibrary", method=RequestMethod.POST)
	    public List<BookModel> getBooksByLibrary(@RequestBody Library library) 
	    {
		 /*Iterable<Book> iterBookList = bookService.getBooksByLibrary(library);*/
		 List<Book> bookList = bookService.getBookByLibrary(library);
		 List<BookModel> booksList = new ArrayList<BookModel>();
		 for(Book book:bookList){
			 BookModel bookModel = new BookModel();
			 bookModel.setBookId(book.getBookId());
			 bookModel.setBookName(book.getBookName());
			 bookModel.setBookISBN(book.getBookISBN());
			 bookModel.setBookPrice(book.getBookPrice());
			 bookModel.setBookAuthor(book.getBookAuthor());
			 booksList.add(bookModel);
		 }
			return booksList;	         
	        	         
	    }
	 
	 
	 

}
