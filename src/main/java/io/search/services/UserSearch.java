package io.search.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import io.search.model.User;

/**
 * Search methods for the entity User using Hibernate search.
 * The Transactional annotation ensure that transactions will be opened and
 * closed at the beginning and at the end of each method.
 * 
 * @author Omar Eisa
 */
@Repository
@Transactional
public class UserSearch {

  // Spring will inject here the entity manager object
  @PersistenceContext
  private EntityManager entityManager;


  /**
   * A basic search for the entity User. The search is done by exact match per
   * keywords on fields FisrtName, lastName,gender,ipadress and email.
   * 
   * @param text The query text.
   */
  public List<User> search(String text) {
    
    // get the full text entity manager
    FullTextEntityManager fullTextEntityManager =
      org.hibernate.search.jpa.Search.
      getFullTextEntityManager(entityManager);
    
    // create the query using Hibernate Search query DSL
    QueryBuilder queryBuilder = 
      fullTextEntityManager.getSearchFactory()
      .buildQueryBuilder().forEntity(User.class).get();
    
    // a very basic query by keywords
    org.apache.lucene.search.Query query =
      queryBuilder
        .keyword()
        .onFields("firstName", "lastName", "gender","email","ipAdress")
        .matching(text)
        .createQuery();

    // wrap Lucene query in an Hibernate Query object
    org.hibernate.search.jpa.FullTextQuery jpaQuery =
      fullTextEntityManager.createFullTextQuery(query, User.class);
  
    // execute search and return results (sorted by relevance as default)
    @SuppressWarnings("unchecked")
    List<User> results = jpaQuery.getResultList();
    
    return results;
  } 

}
