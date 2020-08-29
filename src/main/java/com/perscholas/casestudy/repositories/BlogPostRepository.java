package com.perscholas.casestudy.repositories;

import com.perscholas.casestudy.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}

