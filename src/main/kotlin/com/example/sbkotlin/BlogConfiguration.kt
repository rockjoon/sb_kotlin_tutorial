package com.example.sbkotlin

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer( userRepository: UserRepository,
        articleRepository: ArticleRepository ) = ApplicationRunner {
        val smaldini  = userRepository.save(User("smaldini", "stephan", "maldini"))
        articleRepository.save(Article(
            title = "this is default title",
            headline = "ipsen lauren",
            content = "dolor world shitty",
            author = smaldini
        ))
        articleRepository.save(Article(
            title = "can ever grande pay their debt?",
            headline = "ever grande default warning",
            content = "bitcoin price falls down",
            author = smaldini
        ))
    }
}