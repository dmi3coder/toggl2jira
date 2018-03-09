package io.github.dmitrychaban.toggl2jira

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Toggl2jiraApplication

fun main(args: Array<String>) {
    runApplication<Toggl2jiraApplication>(*args)
}
