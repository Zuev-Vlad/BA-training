package com.sportdiary.training.entities

import com.sportdiary.training.enums.ActivityTypeEnum
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name= "training_notes")
class TrainingNoteEntity (

    @Id
    @GeneratedValue
    var id: UUID? = null,

    @Column(name = "client_id")
    var clientId: UUID,

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "place")
    var place: String? = "",

    @Column(name = "distance_km")
    var distanceKm: Int? = 0,


    @Column(name = "well_being")
    var wellBeing: String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    var activityType: ActivityTypeEnum,

    @Column(name = "training_date")
    var trainingDate: LocalDateTime,

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    var created_at: Date?,

    @Column(name = "version")
    @Version
    var version: Int? = null,

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    var modifiedAt: Date?


)