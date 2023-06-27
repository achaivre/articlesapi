package com.news.news.tag;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TagConfig {
    @Bean
    CommandLineRunner tagCommandLineRunner(TagRepository repository) {
        return args -> {
            Tag tag1 = new Tag("TRUE CRIME");
            Tag tag2 = new Tag("FOOD");
            Tag tag3 = new Tag("CUTE");

            repository.saveAll(
                    List.of(tag1, tag2, tag3)
            );
        };
    }
}
