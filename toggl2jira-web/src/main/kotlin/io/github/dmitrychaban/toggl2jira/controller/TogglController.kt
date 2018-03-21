package io.github.dmitrychaban.toggl2jira.controller

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApiBuilder
import io.github.dmitrychaban.java_toggl_sdk_light.model.Timer
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/toggl")
class TogglController {


    @GetMapping
    fun getTogglWeekReports(@RequestHeader("togglToken") togglToken: String): Mono<List<Timer>> {
        val api = TogglApiBuilder.with(togglToken).build()!!
        api.currentWorkspace = api.context.block()!!.workspaces.first()
        return api.getWeekReport(DateTime.now()).map { it.data }
    }
}
