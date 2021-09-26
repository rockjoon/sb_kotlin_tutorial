package com.example.sbkotlin

data class ArticleResponse(
    val title: String,
    val content: String,
    val slug: String,
    val author: User,
    val createdAt: String,
)

fun Article.render() = ArticleResponse(
    title,
    content,
    slug,
    author,
    createdAt.toString()
)
