package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.simple.SimpleHttpResponseFactory

@Controller
class MainController {

    @Get("/200")
    fun justReturn200(): HttpResponse<String> {
        return SimpleHttpResponseFactory().ok("test")
    }

    @Get("/304")
    fun justReturn304(): HttpResponse<String> {
        return SimpleHttpResponseFactory().status(HttpStatus.NOT_MODIFIED)
    }

}