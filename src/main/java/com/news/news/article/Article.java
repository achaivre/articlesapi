package com.news.news.article;

import com.news.news.author.Author;
import com.news.news.tag.Tag;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Article {
    @Id
    @SequenceGenerator(
            name="article_sequence",
            sequenceName = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_sequence"
    )

    private Long id;
    private String title;
    private String content;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable(
            name="article_tags",
            joinColumns = @JoinColumn(name="article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> articleTags = new HashSet<>();

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Tag> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(Set<Tag> articleTags) {
        this.articleTags = articleTags;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void addTag(Tag tag) {
        articleTags.add(tag);
    }

}
