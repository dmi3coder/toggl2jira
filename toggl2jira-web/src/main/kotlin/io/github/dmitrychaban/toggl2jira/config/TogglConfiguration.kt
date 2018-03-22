package io.github.dmitrychaban.toggl2jira.config

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApiBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Configuration
class TogglConfiguration {

    @Bean
    @Scope("session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun getTogglApi(): TogglApi {
        val curRequest = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val togglToken = curRequest.getHeader("togglToken")
        return TogglApiBuilder.with(togglToken).build()
    }
}
