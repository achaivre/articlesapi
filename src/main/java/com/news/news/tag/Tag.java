package com.news.news.tag;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.news.news.article.Article;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity

public class Tag {
    @Id
    @SequenceGenerator(
            name="tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long id;
    private String tagName;

    @JsonIgnore
    @ManyToMany(mappedBy = "articleTags")
    private Set<Article> articleSet = new HashSet<>();

    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
