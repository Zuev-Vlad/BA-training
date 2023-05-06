package com.sportdiary.training.repository

import com.sportdiary.training.entities.TrainingNoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TrainingNotesRepository : JpaRepository<TrainingNoteEntity, UUID> {}