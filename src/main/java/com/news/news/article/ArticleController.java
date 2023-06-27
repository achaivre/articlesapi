package com.news.news.article;


import com.news.news.author.*;
import com.news.news.tag.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final TagService tagService;
    private final AuthorService authorService;

    @Autowired
    public ArticleController(ArticleService articleService, TagService tagService, AuthorService authorService){
        this.articleService = articleService;
        this.tagService = tagService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @PutMapping(path = "{articleId}/tags/{tagId}")
    public Article addTagToArticle(
            @PathVariable Long articleId,
            @PathVariable Long tagId) {
        Article article = articleService.getOneArticle(articleId);
        Tag tag = tagService.getOneTag(tagId);
        article.addTag(tag);
        return articleService.saveToRepo(article);
    }

    @PutMapping(path = "{articleId}/author/{authorId}")
    public Article addAuthorToArticle(
            @PathVariable Long articleId,
            @PathVariable Long authorId) {
        Article article = articleService.getOneArticle(articleId);
        Author author = authorService.getAuthor(authorId);
        article.setAuthor(author);
        return articleService.saveToRepo(article);
    }

    @DeleteMapping(path = "{articleId}")
    public void deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @GetMapping(path = "{articleId}")
    public Article getOneArticle(@PathVariable Long articleId) {
        return articleService.getOneArticle(articleId);
    }

    @PostMapping
    public void addNewArticle(@RequestBody Article article) {
        articleService.addNewArticle(article);
    }

//    @GetMapping(path = "/byauthor/{authorId}")
//    public List<Article> getArticlesByAuthor(@PathVariable Long authorId) {
//        return articleService.getArticlesByAuthor(authorId);
//    }


}
