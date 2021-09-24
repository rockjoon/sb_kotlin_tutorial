package com.example.sbkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import javax.persistence.EntityManager

@DataJpaTest
class RepositoriesTest @Autowired constructor(
    val articleRepository: ArticleRepository,
    val userRepository: UserRepository) {

    @Test
    fun `when findByIdOrNull then return Article`() {
        val user = User("springuser", "choi", "rockjoon", "test user")
        userRepository.save(user)
        var article = Article("this is title for test", "headline", "content", user)
        articleRepository.save(article)
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    internal fun `when findByLogin then return User`() {
        val user = User("springUser", "choi", "rock")
        userRepository.save(user)
        val found = userRepository.findByLogin(user.login)
        assertThat(found).isEqualTo(user)
    }
}