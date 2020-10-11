package com.perscholas.casestudy.repositories;

import com.perscholas.casestudy.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//
//    @Query(value = "SELECT * FROM author WHERE type = :type", nativeQuery = true)
//    List<Author> findAuthorsByType(@Param("type") String type);
}
