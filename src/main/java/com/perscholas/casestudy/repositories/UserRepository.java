package com.perscholas.casestudy.repositories;

import com.perscholas.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //sample custom query
//    @Query("select u from User u where u.firstname like %?1")
//    List<User> findByFirstnameEndsWith(String firstname);

    // Using named parameters
//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);

//    Query("select u from #{#entityName} u where u.lastname = ?1")
//    List<User> findByLastname(String lastname);
}
