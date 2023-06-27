package com.news.news.article;

import com.news.news.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//    @Query("SELECT a FROM Article a WHERE a.author = ?1")
//    Optional<List<Article>> findArticleByAuthor(Author author);
//

}
