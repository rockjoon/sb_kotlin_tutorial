package com.example.sbkotlin

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @MockkBean
    private lateinit var articleRepository: ArticleRepository

    @Test
    fun `List articles`() {
        val authorA = User("id", "firstName", "lastName")
        val articleA = Article(
            title = "this is title",
            headline = "this is headline",
            content = "world of our own",
            author = authorA,
        )
        val articleB = Article(
            title = "today's weather",
            headline = "windy and bright sky",
            content = "it is good day to take a walk",
            author = authorA,
        )

        every { articleRepository.findAllByOrderByAddedAtDesc() } returns
                listOf(articleA, articleB)

        mockMvc.perform(get("/api/articles/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].author.login").value(authorA.login))
            .andExpect(jsonPath("\$.[0].slug").value(articleA.slug))
            .andExpect(jsonPath("\$.[1].author.login").value(authorA.login))
            .andExpect(jsonPath("\$.[1].slug").value(articleB.slug))
    }

    @Test
    fun `List users`() {
        val userA = User(
            login = "loginA",
            firstName = "firstNameA",
            lastName = "lastNameA",
        )
        val userB = User(
            login = "loginB",
            firstName = "firstNameB",
            lastName = "lastNameB",
        )

        every { userRepository.findAll() } returns
                listOf(userA, userB)

        mockMvc.perform(get("/api/users/").accept(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.[0].login").value(userA.login))
            .andExpect(jsonPath("\$.[1].login").value(userB.login))
    }
}