package io.leonhardt.kotlinspringbootexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringBootExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringBootExampleApplication::class.java, *args)
}
