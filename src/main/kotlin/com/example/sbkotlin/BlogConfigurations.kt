package com.example.sbkotlin

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfigurations {

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository, articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val rockpago = User("rockpago", "rockjoon")
        userRepository.save(rockpago)
        val articleA = Article(
            title = "안녕하시렵니까?? 두번째입니다.",
            content = "기억나지 않는 부분만 보고 다시 만들어 보기",
            author = rockpago
        )
        val articleB = Article(
            title = "bitcoin price falls down by chinese terror",
            content = "과연 앞으로의 운명은 어떻게 될 것인가?",
            author = rockpago
        )
        articleRepository.save(articleA)
        articleRepository.save(articleB)
    }


}