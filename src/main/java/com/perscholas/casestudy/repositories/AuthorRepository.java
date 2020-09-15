package com.perscholas.casestudy.repositories;

import com.perscholas.casestudy.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //sample custom query
//    @Query("select u from Author u where u.firstname like %?1")
//    List<Author> findByFirstnameEndsWith(String firstname);

    // Using named parameters
//    @Query("select u from Author u where u.firstname = :firstname or u.lastname = :lastname")
//    Author findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);

//    Query("select u from #{#entityName} u where u.lastname = ?1")
//    List<Author> findByLastname(String lastname);
}
