package com.example.sbkotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class ArticleController(private val repository: ArticleRepository){

    @GetMapping("/api/articles/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/api/articles/{slug}")
    fun findOne(@PathVariable slug: String)
        = repository.findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "article not found")

}

@RestController
class UserController(private val repository: UserRepository) {

    @GetMapping("/api/users/")
    fun findAll() = repository.findAll()

    @GetMapping("/api/users/{login}")
    fun findOne(@PathVariable login:String)
        = repository.findByLogin(login) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")

}
