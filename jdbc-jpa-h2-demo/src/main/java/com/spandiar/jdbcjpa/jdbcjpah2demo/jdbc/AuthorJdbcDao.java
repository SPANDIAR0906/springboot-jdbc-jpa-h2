package com.spandiar.jdbcjpa.jdbcjpah2demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spandiar.jdbcjpa.jdbcjpah2demo.entity.Author;

@Repository
public class AuthorJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class AuthorRowMapper implements RowMapper<Author> {

		@Override
		public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Author author = new Author();
			
			author.setId(rs.getInt("id"));
			author.setName(rs.getString("name"));
//			author.setDob(rs.getDate("dob"));
			author.setGender(rs.getString("gender"));
//			author.setCreatedDate(rs.getDate("created_dt"));
//			author.setModifiedDate(rs.getDate("modified_dt"));
			
			return author;
		}
		
	}
	
	public List<Author> findAll() {
		
		return jdbcTemplate.query("select * from author", new AuthorRowMapper());
		
	}
	
	@SuppressWarnings("deprecation")
	public Author findById(int id) {
		
		return jdbcTemplate.queryForObject("select * from author where id=?", 
							 new Object[] {id},
							  new BeanPropertyRowMapper<Author>(Author.class));
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public Author findByName(String name) {
		
		return jdbcTemplate.queryForObject("select * from author where lower(name) like %" + "?" + "%", 
							         new String[] { name.toLowerCase() },
							           new BeanPropertyRowMapper<Author>(Author.class));
		
	}
	
	
	public int addNewAuthor(Author author) {
		
		return jdbcTemplate.update(
				"insert into author (id, name, dob, gender, created_dt, modified_dt) "
			    	+ "values (?,?,?,?,?,?)",
			    	  new Object[] {author.getId(), author.getName(), 
//			    			  			new Timestamp(author.getDob().getTime()), 
			    			  					author.getGender(),
			    			  					  new Timestamp(new Date().getTime()),
			    			  					   new Timestamp(new Date().getTime())}
				);
	}

}
