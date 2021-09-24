package com.example.sbkotlin

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>?
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(longin: String): User?
}