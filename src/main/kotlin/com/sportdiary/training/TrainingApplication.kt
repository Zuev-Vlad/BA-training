package com.sportdiary.training

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync


@EnableAsync
@SpringBootApplication
class TrainingApplication

fun main(args: Array<String>) {
	runApplication<TrainingApplication>(*args)
}
