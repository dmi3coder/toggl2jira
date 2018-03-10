package io.github.dmitrychaban.toggl2jira

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApiBuilder
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Toggl2jiraApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        val api = TogglApiBuilder.with(null).build()
        println(api.context.block()!!.fullname)

    }
}

fun main(args: Array<String>) {
    runApplication<Toggl2jiraApplication>(*args)
}
