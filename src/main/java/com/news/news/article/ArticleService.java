package com.news.news.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final com.news.news.article.ArticleRepository articleRepository;

    @Autowired
    public ArticleService(com.news.news.article.ArticleRepository repository) {
        this.articleRepository = repository;
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article getOneArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalStateException("article with this id doesn't exist"));
        return article;
    }

    public Article saveToRepo(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Long articleId) {
        boolean exists = articleRepository.existsById(articleId);
        if (!exists) {
            throw new IllegalStateException(
                    "author with this id doesn't exist."
            );
        }
        articleRepository.deleteById(articleId);
    }

    public void addNewArticle(Article article) {
        articleRepository.save(article);
    }

//    public List<Article> getArticlesByAuthor(Long authorId) {
//        List<Article> articles = articleRepository.findArticleByAuthor()
//
//    }
}
