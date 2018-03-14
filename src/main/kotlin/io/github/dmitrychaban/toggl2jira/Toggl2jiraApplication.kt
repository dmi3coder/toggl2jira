package io.github.dmitrychaban.toggl2jira

import io.github.dmitrychaban.java_jira_sdk_light.JiraApi
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Flux

@SpringBootApplication
class Toggl2jiraApplication : CommandLineRunner {

    @Autowired
    lateinit var api: TogglApi
    @Autowired
    lateinit var jiraApi: JiraApi

    override fun run(vararg args: String?) {
        val project = jiraApi.getJiraProjects().flatMapMany { Flux.fromIterable(it) }.filter { it.name == "MyProject" }.collectList().block()!!.first()
        val workspaces = api.context.block()!!.workspaces
        api.currentWorkspace = workspaces.first()
        val timeReport = api.getWeekReport(DateTime.now()).block()!!
        val comparedObjects = jiraApi.getTasksByProject(project, System.currentTimeMillis(), 100)
                .flatMapMany { Flux.fromIterable(it.issues) }
                .map {
                    val togglTitle = "${it.key} ${it.fields.summary}"
                    val groupedElements = timeReport.data.groupBy { it.description }
                    if (groupedElements.containsKey(togglTitle)) {
                        return@map Pair(it, groupedElements[togglTitle])
                    } else {
                        return@map Pair(it, null)
                    }
                }
                .filter { it.second != null }.collectList().block()!!
        comparedObjects.forEach {
            println("${it.first.key}: ${it.second!!.sumBy { it.dur } / 1000 / 60} min")
        }

    }
}

fun main(args: Array<String>) {
    runApplication<Toggl2jiraApplication>(*args)
}
