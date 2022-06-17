package com.stripe.demo.repository;

import com.stripe.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository  extends JpaRepository<Article, Long> {
}
