package com.example.sbkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SbKotlinApplication

fun main(args: Array<String>) {
	runApplication<SbKotlinApplication>(*args)
}
