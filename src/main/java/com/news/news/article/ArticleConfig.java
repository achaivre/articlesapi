package com.news.news.article;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class ArticleConfig {
    @Bean
    CommandLineRunner articleCommandLineRunner(ArticleRepository repository) {
        return args -> {
            Article article1 = new Article("BEST FOOD EVER", "The best thing we have ever eaten is pizza.");
            Article article2 = new Article("CRIME IS BAD", "Hurt people hurt people. So crime is done by hurt people.");
            Article article3 = new Article("CUTE PUPPIES SAVE THE DAY", "Puppies visit a graveyard in mass today and help heal hurt hearts.");


            repository.saveAll(
                    List.of(article1, article2, article3)
            );
        };
    }
}
