package io.github.dmitrychaban.toggl2jira.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class ForwardController {

    @RequestMapping(value = ["/**/{[path:[^\\.]*}"])
    fun redirect(): String {
        // Forward to home page so that route is preserved.
        return "forward:/"
    }
}
