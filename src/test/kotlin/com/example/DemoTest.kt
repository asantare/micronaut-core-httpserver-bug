package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class DemoTest() : StringSpec() {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient


    init {
        "server should return 200" {
            val resp = client.toBlocking().exchange("/200", String::class.java)
            resp.status shouldBe HttpStatus.OK
            resp.body().shouldBe("test")
        }

        "server should return 304" {
            val resp = client.toBlocking().exchange<String?>("/304")
            resp.status shouldBe HttpStatus.NOT_MODIFIED
            resp.body().shouldBeNull()
        }
    }
}
