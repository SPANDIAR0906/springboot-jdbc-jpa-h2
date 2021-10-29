package com.spandiar.jdbcjpa.jdbcjpah2demo;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spandiar.jdbcjpa.jdbcjpah2demo.entity.Author;
import com.spandiar.jdbcjpa.jdbcjpah2demo.jpa.AuthorJpaRepository;

@SpringBootApplication
public class JdbcJpaH2DemoApplication implements CommandLineRunner{
	
	@Autowired
	AuthorJpaRepository jpaRepo;
	
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(JdbcJpaH2DemoApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(JdbcJpaH2DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("\n Specific Author -> {} ", jpaRepo.findById(10000));
		logger.info("\n Specific Author Name Search -> {} ", jpaRepo.findByAuthorName("Brown"));

//		logger.info("\n Total Rows -> {} ", jpaRepo.countRows());
		jpaRepo.insertAuthor(new Author("Paulo Coelho", LocalDate.of(1965, 04, 18), "M"));
//		logger.info("\n Inserting a new author ", jpaRepo.insertAuthor(new Author("Paulo Coelho", LocalDate.of(1965, 04, 18), "M")));
		logger.info("\n Updating Author -> {} ", jpaRepo.updateAuthor(new Author(1, "Paulo Coelho", LocalDate.of(1955, 04, 18), "M")));
		logger.info("\n All Authors -> {} ", jpaRepo.findAll());
		
		
		
//		logger.info("\n Specific Author -> {} ", dao.findByName("brown"));
//		logger.info("\n Adding new author -> {} ", dao.addNewAuthor(new Author(10003, "Paulo Coelho", new Date(45, 12, 15), "M")));

	}

}
