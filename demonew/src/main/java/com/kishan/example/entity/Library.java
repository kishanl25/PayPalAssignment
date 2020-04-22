package com.kishan.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Library")
public class Library implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1572366147058327664L;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "LIBRARY_ID")
	private Long libraryId;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_seq")
    @SequenceGenerator(name="library_id_seq", sequenceName = "LIBRARY_ID_SEQ", allocationSize = 1)
	@Column(name = "LIBRARY_ID")
	private Long libraryId;
	
	@Column(name = "LIBRARY_NAME")
	private String libraryName;
	
	public Library(){
		
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
