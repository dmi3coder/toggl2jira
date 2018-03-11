package io.github.dmitrychaban.toggl2jira.config

import io.github.dmitrychaban.java_toggl_sdk_light.TogglApi
import io.github.dmitrychaban.java_toggl_sdk_light.TogglApiBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TogglConfiguration {

    @Value("\${togglApi.token}")
    lateinit var togglToken: String

    @Bean
    fun getTogglApi(): TogglApi = TogglApiBuilder.with(togglToken).build()

}
