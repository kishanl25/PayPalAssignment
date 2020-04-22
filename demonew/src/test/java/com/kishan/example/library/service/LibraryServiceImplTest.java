package com.kishan.example.library.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kishan.example.dao.LibraryDAO;
import com.kishan.example.entity.Library;
import com.kishan.example.service.LibraryService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class LibraryServiceImplTest {
	
	@Tested(fullyInitialized = true) // This Annotation is used for class which we are going to test
	private LibraryService libraryService;
	
	@Injectable // This Annotation is used mock Service
	private LibraryDAO libraryDao;
	private List<Library> libraryList;
	
	@Test
	public void getAllLibrariesTestCaseOne() {
		List<Library> allLibraries = Collections.emptyList();
		new Expectations() {
			{
				libraryService.getAllLibraries();
				result = allLibraries;
			}
		};
		List<Library> expectedResult = libraryService.getAllLibraries();
		Assert.assertTrue(expectedResult.isEmpty());
	}
	
	@Test
	public void getAllLibrariesTestCaseTwo() {
		List<Library> allLibraries = new ArrayList<>(1);
		allLibraries.add(buildSampleLibrary());
		new Expectations() {
			{
				libraryService.getAllLibraries();
				result = allLibraries;
			}
		};
		List<Library> expectedResult = libraryService.getAllLibraries();
		Assert.assertEquals(1, expectedResult.size());
	}
	
	@Test(expectedExceptions = Exception.class)
	public void getAllLibrariesTestCaseThree() throws Exception {

		new Expectations() {
			{
				libraryService.getAllLibraries();
				result = new Exception();
			}
		};
		libraryService.getAllLibraries();
	}	
	
	@Test
	public void saveLibraryTestCaseOne() {
		Library libraryObj = new Library();
		libraryObj.setLibraryName("Sci-FI");
		new Expectations() {
			{
				libraryService.saveLibrary(libraryObj);
				result = buildSampleLibrary();
			}
		};
		Library expectedResult = libraryService.saveLibrary(libraryObj);
		Assert.assertNotNull(expectedResult);
	}
	
	@Test
	public void saveLibraryTestCaseTwo() {
		Library libraryObj = new Library();
		libraryObj.setLibraryName("Sci-FI");
		new Expectations() {
			{
				libraryService.saveLibrary(libraryObj);
				result = null;
			}
		};
		Library expectedResult = libraryService.saveLibrary(libraryObj);
		Assert.assertNull(expectedResult);
	}
	

	private Library buildSampleLibrary() {
		Library libraryObj = new Library();
		libraryList = new ArrayList<Library>();
		libraryObj.setLibraryName("Sci-FI");
		libraryList.add(libraryObj);
		return libraryObj;
	}

}
