package io.github.dmitrychaban.toggl2jira.config

import io.github.dmitrychaban.java_jira_sdk_light.DefaultJiraApi
import io.github.dmitrychaban.java_jira_sdk_light.JiraApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes



@Configuration
class JiraConfiguration {

    @Bean
    @Scope("session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun getJiraApi() : JiraApi {
        val curRequest = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val jiraToken = curRequest.getHeader("jiraToken")
        val jiraMail = curRequest.getHeader("jiraMail")
        return DefaultJiraApi(jiraToken, jiraMail)
    }
}
