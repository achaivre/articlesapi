package com.news.news.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AuthorConfig {
    @Bean
    CommandLineRunner authorCommandLineRunner(AuthorRepository repository) {
        return args -> {
            Author author1 = new Author(
                    "Alyx",
                    "Chaivre",
                    LocalDate.of(1995, Month.JUNE, 9)
            );
            Author author2 = new Author(
                    "Drew",
                    "Cornelius",
                    LocalDate.of(1996, Month.JUNE, 9)
            );

            repository.saveAll(
                    List.of(author1, author2)
            );
        };
    }
}
