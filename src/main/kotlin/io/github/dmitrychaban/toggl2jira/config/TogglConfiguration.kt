package io.github.dmitrychaban.toggl2jira.config

import io.rocketbase.toggl.api.TogglReportApi
import io.rocketbase.toggl.api.TogglReportApiBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TogglConfiguration {

    @Value("\${TOGGL_TOKEN}")
    private lateinit var togglToken: String

    @Bean
    fun getTogglReportApi(): TogglReportApi {
        return TogglReportApiBuilder()
                .setApiToken(togglToken)
                .setWorkspaceId(2510926).build()
    }
}
