package com.news.news.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagService {
    private final com.news.news.tag.TagRepository tagRepository;

    @Autowired
    public TagService(com.news.news.tag.TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag getOneTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new IllegalStateException("tag with this id doesn't exist"));
        return tag;
    }
}
