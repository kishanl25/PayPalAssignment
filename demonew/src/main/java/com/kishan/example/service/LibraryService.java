package com.kishan.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishan.example.dao.LibraryDAO;
import com.kishan.example.entity.Library;

@Service
public class LibraryService {
	
	@Autowired
	LibraryDAO libraryDao;
	
	public List<Library> getAllLibraries(){
		return this.libraryDao.findAll();
	}
	
	public Library saveLibrary(Library libraryObj){
		Library library = this.libraryDao.save(libraryObj);
		return library;		
	}
	
	public boolean deleteLibrary(Library libraryObj){
		this.libraryDao.delete(libraryObj);
		return true;
	}
}
