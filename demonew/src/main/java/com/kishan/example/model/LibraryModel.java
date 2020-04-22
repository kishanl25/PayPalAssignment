package com.kishan.example.model;

public class LibraryModel {
	
	private Long libraryId;	
	private String libraryName;
	
	public LibraryModel(){
		
	}
	
	public LibraryModel(Long libraryId, String libraryName){
		this.libraryId = libraryId;
		this.libraryName = libraryName;
	}

	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	

}
