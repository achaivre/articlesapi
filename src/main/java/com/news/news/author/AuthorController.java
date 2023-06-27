package com.news.news.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(path="{authorId}")
    public ResponseEntity getAuthor(@PathVariable("authorId") Long authorId) {
        try {
            var authorToReturn =  authorService.getAuthor(authorId);
            return new ResponseEntity(authorToReturn, HttpStatus.OK);
        } catch (IllegalStateException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void addNewAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path="{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping(path="{authorId}")
    public void updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required=false) String firstName,
            @RequestParam(required=false) String lastName) {
        authorService.updateAuthor(authorId, firstName, lastName);
    }
}
