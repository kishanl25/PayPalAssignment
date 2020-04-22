package com.kishan.example.demonew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;
import com.kishan.example.service.BookService;
import com.kishan.example.service.LibraryService;
@PropertySource("application.properties")
@EnableConfigurationProperties
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.kishan"})
@ComponentScan(basePackages = {"com.kishan.example.controller","com.kishan.example.service","com.kishan.example.dao"})
@EntityScan(basePackages = {"com.kishan"})
@SpringBootApplication(scanBasePackages = {"com.kishan"})
public class DemonewApplication implements CommandLineRunner{
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemonewApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Library> libraryList = libraryService.getAllLibraries();
		for (Library lib : libraryList) {
			List<Book> bookList = bookService.getBookByLibrary(lib);
			System.out.println(lib.getLibraryName());
		}		
		/*Library libraryObj = new Library();
		libraryObj.setLibraryName("Mythological");
		libraryService.saveLibrary(libraryObj);*/
	}

}
