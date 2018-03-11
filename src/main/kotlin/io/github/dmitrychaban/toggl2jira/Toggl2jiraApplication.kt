package io.github.dmitrychaban.toggl2jira

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Toggl2jiraApplication : CommandLineRunner {

    @Autowired
    lateinit var api: TogglApi

    override fun run(vararg args: String?) {
        var workspaces = api.context.block()!!.workspaces
        println(api.currentWorkspace)
        api.currentWorkspace = workspaces.first()
        println(api.getWeekReport(DateTime.now()).block())
    }
}

fun main(args: Array<String>) {
    runApplication<Toggl2jiraApplication>(*args)
}
