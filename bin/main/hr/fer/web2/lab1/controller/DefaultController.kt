package hr.fer.web2.lab1.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/", produces = ["application/json"])
@CrossOrigin(origins = ["http://localhost:3000"])
class DefaultController {

    @GetMapping("/default")
    fun index(): String {
        return "Hello World!"
    }

    @GetMapping("/okay")
    @CrossOrigin(origins = ["http://localhost:3000"])
    fun okay(): String {
        return "Okay"
    }

    @GetMapping
    fun root(): String {
        return "Root"
    }

    @PostMapping("/post")
    fun post(): String {
        return "Post"
    }

}