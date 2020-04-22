import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kishan.example.dao.BookDAO;
import com.kishan.example.entity.Book;
import com.kishan.example.service.BookService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class BookServiceImplTest {
	
	@Tested(fullyInitialized = true)
	private BookService bookService;
	
	@Injectable // This Annotation is used mock Service
	private BookDAO bookDao;
	
	@Test
	public void getAllBooksTestCaseOne() {
		List<Book> allBooks = Collections.emptyList();
		new Expectations() {
			{
				bookService.getAllBooks();
				result = allBooks;
			}
		};
		List<Book> expectedResult = bookService.getAllBooks();
		Assert.assertTrue(expectedResult.isEmpty());
	}
	
	@Test
	public void getAllBooksTestCaseTwo() {
		List<Book> allBooks = new ArrayList<>(1);
		allBooks.add(buildSampleBook());
		new Expectations() {
			{
				bookService.getAllBooks();
				result = allBooks;
			}
		};
		List<Book> expectedResult = bookService.getAllBooks();
		Assert.assertEquals(1, expectedResult.size());
	}
	

	@Test(expectedExceptions = Exception.class)
	public void getAllBooksTestCaseThree() throws Exception {

		new Expectations() {
			{
				bookService.getAllBooks();
				result = new Exception();
			}
		};
		bookService.getAllBooks();
	}
	
	@Test
	public void saveBookTestCaseOne() {
		Book bookObj = new Book();
		bookObj.setBookName("SNOW WHITE & SEVEN DWARF");
		new Expectations() {
			{
				bookService.saveBook(bookObj);
				result = buildSampleBook();
			}
		};
		Book expectedResult = bookService.saveBook(bookObj);
		Assert.assertNotNull(expectedResult);
	}
	
	@Test
	public void saveBookTestCaseTwo() {
		Book bookObj = new Book();
		bookObj.setBookName("SNOW WHITE & SEVEN DWARF");
		new Expectations() {
			{
				bookService.saveBook(bookObj);
				result = null;
			}
		};
		Book expectedResult = bookService.saveBook(bookObj);
		Assert.assertNull(expectedResult);
	}
	
	private Book buildSampleBook() {
		Book bookObj = new Book();
		bookObj.setBookName("SNOW WHITE & SEVEN DWARF");
		bookObj.setBookISBN("ISBN005");
		bookObj.setBookPrice(350.00);
		bookObj.setBookAuthor("MISC");		
		return bookObj;
	}

}
