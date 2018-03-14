package io.github.dmitrychaban.toggl2jira.config

import io.github.dmitrychaban.java_jira_sdk_light.DefaultJiraApi
import io.github.dmitrychaban.java_jira_sdk_light.JiraApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JiraConfiguration {

    @Bean
    fun getJiraApi() : JiraApi = DefaultJiraApi("1uQlZ2t68vISPhEmWHMl1B64", "dchaban@s-pro.io")
}
