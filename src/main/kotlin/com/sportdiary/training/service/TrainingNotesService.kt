package com.sportdiary.training.service

import com.sportdiary.training.entities.TrainingNoteEntity
import com.sportdiary.training.repository.TrainingNotesRepository
import org.springframework.stereotype.Service

@Service
class TrainingNotesService(
    val trainingNotesRepository: TrainingNotesRepository
) {

    fun getAllTrainingNotes(): MutableList<TrainingNoteEntity> = trainingNotesRepository.findAll()

    fun createTrainingNotes(trainingNoteEntity: TrainingNoteEntity): TrainingNoteEntity = trainingNotesRepository.save(trainingNoteEntity)
}