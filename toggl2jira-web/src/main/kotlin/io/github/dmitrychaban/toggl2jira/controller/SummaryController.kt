package io.github.dmitrychaban.toggl2jira.controller

import io.github.dmitrychaban.java_jira_sdk_light.DefaultJiraApi
import io.github.dmitrychaban.java_jira_sdk_light.JiraApi
import io.github.dmitrychaban.java_jira_sdk_light.model.JiraProject
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApiBuilder
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/summary")
class SummaryController {

    @Autowired
    lateinit var jiraApi: JiraApi

    @Autowired
    lateinit var togglApi: TogglApi

    @GetMapping
    fun getSummary(): String {
        val project: JiraProject = jiraApi.getJiraProjects().flatMapMany { Flux.fromIterable(it) }.filter { it.name == "Airlog" }.collectList().block()!!.first()
        val workspaces = togglApi.context.block()!!.workspaces
        togglApi.currentWorkspace = workspaces.first()
        val timeReport = togglApi.getWeekReport(DateTime.now()).block()!!
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
        return "";
    }
}
