package io.github.dmitrychaban.toggl2jira

import com.fasterxml.jackson.databind.util.JSONPObject
import com.fasterxml.jackson.databind.util.JSONWrappedObject
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ActionController {

    @GetMapping("/test")
    fun fetch() : Mono<String>  {
        return Mono.just("test")
    }

}
