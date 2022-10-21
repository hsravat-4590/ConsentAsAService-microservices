package com.ravathanzalah.consentservice.gradle.spring

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

const val SPRING_FRAMEWORK_VERSION = "5.3.23"
const val SPRING_CONFIG_PROCESSOR_VERSION = "2.7.4"

val coreSpringImplementations = listOf(
    "org.springframework:spring-core:$SPRING_FRAMEWORK_VERSION",
    "org.springframework:spring-beans:$SPRING_FRAMEWORK_VERSION",
    "org.springframework:spring-context:$SPRING_FRAMEWORK_VERSION",
)

val coreSpringAnnotationProcessors = listOf(
    "org.springframework.boot:spring-boot-configuration-processor:$SPRING_CONFIG_PROCESSOR_VERSION"

)
internal fun Project.configureDependencies() = dependencies {
    coreSpringImplementations.forEach {
        add("implementation", it)
    }
    coreSpringAnnotationProcessors.forEach {
        add("annotationProcessor", it)
        add("compileOnly", it)
    }
}