package com.ravathanzalah.consentservice.gradle.spring

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

class SpringPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.configureDependencies()
        project.configurePlugins()
    }
}