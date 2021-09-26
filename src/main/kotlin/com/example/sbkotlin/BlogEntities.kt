package com.example.sbkotlin

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    var title: String,
    var content: String,
    var slug: String = title.toSlug(),
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var author: User,
    @Id @GeneratedValue
    var id: Long? = null
)

@Entity
class User(
    var login: String,
    var name: String,
    @Id @GeneratedValue
    var id: Long? = null
)