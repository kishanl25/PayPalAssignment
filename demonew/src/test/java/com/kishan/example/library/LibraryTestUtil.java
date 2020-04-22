package com.kishan.example.library;

import com.kishan.example.entity.Library;

public class LibraryTestUtil {
	
	public static final String LIBRARY_NAME = "WAR STORIES";
	
	
	public static Library buildSampleLibrary() {
		Library libraryObj = new Library();
		libraryObj.setLibraryName(LIBRARY_NAME);
		return libraryObj;
	}

}
