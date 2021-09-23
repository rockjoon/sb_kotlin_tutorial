package com.example.sbkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HtmlControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setUp() {
        println("before all")
    }

    @Test
    fun `블로그 홈 페이지`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun test() {
        println("test")
    }

    @AfterAll
    internal fun tearDown() {
        println("after all")
    }
}
