package com.example.sbkotlin

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HttpControllersTest(@Autowired private val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @MockkBean
    private lateinit var articleRepository: ArticleRepository

    private lateinit var user : User

    @BeforeEach
    internal fun setUp() {
        user = User(
            login = "rockpago",
            name = "rockjoon"
        )
    }

    @Test
    fun `articles 조회 api 테스트`() {

        val article1 = Article(
            title = "title1",
            content = "content1",
            author = user
        )
        val article2 = Article(
            title = "title2",
            content = "content2",
            author = user
        )

        every { articleRepository.findAllByOrderByCreatedAtDesc() } returns
                listOf(article1, article2)

        mockMvc.perform(get("/api/articles/").accept(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.[0].slug").value(article1.slug))
            .andExpect(jsonPath("\$.[1].slug").value(article2.slug))
    }

    @Test
    fun `users 조회 테스트`() {
        every { userRepository.findAll() } returns listOf(user)

        mockMvc.perform(get("/api/users/").accept(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.[0].login").value(user.login))
    }

}