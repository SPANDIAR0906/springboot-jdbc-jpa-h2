package com.spandiar.jdbcjpa.jdbcjpah2demo.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spandiar.jdbcjpa.jdbcjpah2demo.entity.Author;

@SpringBootTest
class AuthorJpaRepositoryTest {
	
	@Autowired
	private AuthorJpaRepository authorRepo;
	
	private static Logger logger = LoggerFactory.getLogger(AuthorJpaRepositoryTest.class);

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		logger.info("Starting -> {}", "testFindById");
		
		Author author = authorRepo.findById(10000);
		assertEquals("Jeffrey Archer", author.getName());
	}

	@Test
	void testInsertAuthor() {
		
		logger.info("Starting -> {}", "testInsertAuthor");

		Author author = new Author("Amarar Kalki", LocalDate.of(1899, 9, 9), "M");
		Author insertedAuthor = authorRepo.insertAuthor(author);
		Author getInsertedAuthor = authorRepo.findById(insertedAuthor.getId());
		
		assertEquals("Amarar Kalki", getInsertedAuthor.getName());
		
	}

	@Test
	void testUpdateAuthor() {
		
		logger.info("Starting -> {}", "testUpdateAuthor");

		
		Author author = new Author("Sandilyan", LocalDate.of(1910, 11, 6), "F");
		Author insertedAuthor = authorRepo.insertAuthor(author);
		
		insertedAuthor.setGender("M");
	
		Author updatedAuthor = authorRepo.updateAuthor(insertedAuthor);
		
		assertEquals("M", updatedAuthor.getGender());
	}
	
	@Test
	void testCountRows() {
		
		logger.info("Starting -> {}", "testCountRows");
		int countRows = authorRepo.countRows();

		logger.info("Starting -> {}", "testCountRows returned " + countRows);
		assertEquals(5, countRows);
		
	}

}
