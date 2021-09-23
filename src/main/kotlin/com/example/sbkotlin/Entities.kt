package com.example.sbkotlin

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne
    var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue
    var id: Long? = null,
)

@Entity
class User(
    var firstName: String,
    var lastName: String,
    var description: String? = null,
    @Id @GeneratedValue
    var id: Long? = null,
)