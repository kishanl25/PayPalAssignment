package com.kishan.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;

@Repository
public interface BookDAO extends JpaRepository<Book, Long>{
	
	public List<Book> getBooksByLibrary(Library library);
	
	/*@Query("select * from Book b")
	public List<Book> getAllBooks();
*/
	 @Query("FROM Book b where b.library.libraryId = :libraryId")
	public Iterable<Book> findBookByLibrary(@org.springframework.data.repository.query.Param("libraryId") Long libraryId);
}
