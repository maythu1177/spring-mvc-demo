package com.sp.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.tech.model.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

}
