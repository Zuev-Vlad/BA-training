package com.sportdiary.training.controller

import com.sportdiary.training.entities.TrainingNoteEntity
import com.sportdiary.training.service.SleepControllerAsync
import com.sportdiary.training.service.TrainingNotesService
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit


@RestController
@RequestMapping(value = ["api/v1/training-notes"])
@CrossOrigin
class TrainingNotesController(
    val trainingNotesService: TrainingNotesService
) {

    @GetMapping("/")
    fun getAll() = trainingNotesService.getAllTrainingNotes()

    @PostMapping("/create")
    fun createTrainingNotes(@RequestBody trainingNote: TrainingNoteEntity): TrainingNoteEntity {
        return trainingNotesService.createTrainingNotes(trainingNote)
    }

    @GetMapping("/sleep/{countSec}")

    fun getSleepResponse(
        @PathVariable(name = "countSec") countSec: Long
    ): ResponseEntity<*> {
        val firstSleep = SleepControllerAsync.getSleepResult(countSec)
        val secondSleep = SleepControllerAsync.getSleepResult(countSec)
        while (true) {
            if (firstSleep.isDone && secondSleep.isDone) {
                return ResponseEntity
                    .ok()
                    .body("${firstSleep.get()} and ${secondSleep.get()}");
            }
        }
    }


}