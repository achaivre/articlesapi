package com.news.news.author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {
    private final com.news.news.author.AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if (!exists) {
            throw new IllegalStateException(
                    "author with this id doesn't exist."
            );
        }
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Long authorId, String firstName, String lastName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException("author with this id doesn't exist"));

        if (firstName != null
        && firstName.length() > 0
        && !Objects.equals(author.getFirstName(), firstName)) {
            author.setFirstName(firstName);
        }

        if (lastName != null
                && lastName.length() > 0
                && !Objects.equals(author.getLastName(), lastName)) {
            author.setLastName(lastName);
        }
    }

    public Author getAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException("author with this id doesn't exist"));

        return author;
    }

}
