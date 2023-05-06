--liquibase formatted sql
--changeset zvlad:2023-02-05_create_training_notes_table.sql
CREATE TABLE training_notes(
   id UUID PRIMARY KEY NOT NULL,
   client_id UUID NOT NULL,
   description VARCHAR,
   place VARCHAR(50),
   distance_km INT,
   well_being VARCHAR(20),
   activity_type VARCHAR(50) NOT NULL,
   training_date TIMESTAMP NOT NULL,
   created_at TIMESTAMP,
   version INT,
   modified_at TIMESTAMP
);
