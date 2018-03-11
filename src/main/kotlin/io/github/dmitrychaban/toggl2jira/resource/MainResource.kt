package io.github.dmitrychaban.toggl2jira.resource

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainResource {
    @Autowired
    lateinit var api: TogglApi

    @GetMapping("/")
    fun index(model: Model) : String {
        model.addAttribute("timing", api.getWeekReport(DateTime.now()).block()!!.data)
        return "index"
    }
}
