package com.spandiar.jdbcjpa.jdbcjpah2demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spandiar.jdbcjpa.jdbcjpah2demo.entity.Author;
import com.spandiar.jdbcjpa.jdbcjpah2demo.jdbc.AuthorJdbcDao;

@SpringBootApplication
public class JdbcJpaH2DemoApplication implements CommandLineRunner{
	
	@Autowired
	private AuthorJdbcDao dao;
	
	@Autowired
	private static Logger logger;

	public static void main(String[] args) {
		
		logger = LoggerFactory.getLogger(JdbcJpaH2DemoApplication.class);
				
		SpringApplication.run(JdbcJpaH2DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("\n All Authors -> {} ", dao.findAll());
		logger.info("\n Specific Author -> {} ", dao.findById(10001));
//		logger.info("\n Specific Author -> {} ", dao.findByName("brown"));
		logger.info("\n Adding new author -> {} ", dao.addNewAuthor(new Author(10003, "Paulo Coelho", new Date(1970, 12, 15), "M")));

	}

}
