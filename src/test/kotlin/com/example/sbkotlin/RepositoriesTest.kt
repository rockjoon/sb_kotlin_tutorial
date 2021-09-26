package com.example.sbkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class RepositoriesTest @Autowired constructor(
    val articleRepository: ArticleRepository,
    val userRepository: UserRepository,
) {
    lateinit var user: User
    lateinit var article: Article

    @BeforeEach
    internal fun setUp() {
        user = User(
            login = "rockpago",
            name = "rock"
        )
        article = Article(
            title = "spring boot by kotlin tutorials",
            content = "second try",
            author = user
        )
    }

    @Test
    fun `slug로 article 가져오기`() {
        userRepository.save(user)
        articleRepository.save(article)
        val found = articleRepository.findBySlug(article.slug)

        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `login으로 user 가져오기`() {
        userRepository.save(user)
        val found: User = userRepository.findByLogin(user.login)!!

        assertThat(found).isEqualTo(user)
    }
}