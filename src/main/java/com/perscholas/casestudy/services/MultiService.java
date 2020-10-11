package com.perscholas.casestudy.services;

//import com.perscholas.casestudy.models.Author;
//import org.springframework.data.jpa.repository.Query;
import com.perscholas.casestudy.models.Author;
import com.perscholas.casestudy.models.BlogPost;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MultiService {

    @PersistenceContext
    private EntityManager entityManager;

    public Iterable<BlogPost> getAdminPosts() {
        Query query = entityManager.createQuery("select bp from BlogPost bp, Author a where bp.author.id = a.id and a.type = 'admin'");
        //System.out.println("IN THE INDEX IN SERVICE");
        return query.getResultList();
    }

    //@Query(value = "SELECT * FROM author WHERE type = :type", nativeQuery = true)
    public Iterable<Author> findAuthorsByType(String type) {
        Query query = entityManager.createQuery("SELECT a FROM Author a WHERE a.type = '" + type +"'");
        return query.getResultList();
    }

//    public Iterable<Author> index() {
//        Query query = entityManager.createQuery("select a from Author a");
//        System.out.println("IN THE INDEX IN SERVICE");
//        return query.getResultList();
//    }
//
//    public Author show(Long id) {
//        Query query = entityManager.createQuery("select a from Author a where a.id = " + id);
//        return (Author)query.getSingleResult();
//    }
//
//    public Long create(Author author) {
//        entityManager.persist(author);
//        return author.getId();
//    }


}
