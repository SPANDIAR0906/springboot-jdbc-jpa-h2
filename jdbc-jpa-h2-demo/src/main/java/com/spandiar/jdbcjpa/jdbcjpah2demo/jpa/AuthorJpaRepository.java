package com.spandiar.jdbcjpa.jdbcjpah2demo.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spandiar.jdbcjpa.jdbcjpah2demo.entity.Author;

@Repository
@Transactional
public class AuthorJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Author> findAll(){
		
		TypedQuery<Author> namedQuery = entityManager.createNamedQuery("find_all_authors", Author.class);
		
		namedQuery.setMaxResults(3);
		return namedQuery.getResultList();
		
	}
	
	public Author findById(int id) {
		
		return entityManager.find(Author.class, id);
	}
	
	public Author insertAuthor(Author author) {
		
		return entityManager.merge(author);

	}
	
	public Author updateAuthor(Author author) {
		
		return entityManager.merge(author);
	}
	
	public int countRows() {
		
		Query countRows = entityManager.createNativeQuery("select count(1) from author a", Integer.class);
		return (int) countRows.getSingleResult();
		
	}
	
	public Author findByAuthorName(String author) {
		
//		Query findByAuthor = entityManager.createNativeQuery("select a.* from author a where a.name like :authorName", Author.class);
		Query findByAuthor = entityManager.createNativeQuery("select a.* from author a where a.name like concat('%',:authorName,'%')", Author.class);

//		findByAuthor.setParameter("authorName", "%" + author + "%");
		findByAuthor.setParameter("authorName", author);
		
		return (Author) findByAuthor.getSingleResult();
		
	}

}
