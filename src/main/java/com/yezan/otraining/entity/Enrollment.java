package com.yezan.otraining.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "enrollments")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id = new EnrollmentId();

    private LocalDateTime enrollmentDate;

    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setTraining(Training training) {
        this.getId().setTraining(training);
    }

    public Training getTraining() {
        return this.getId().getTraining();
    }

    public void setTrainee(Trainee trainee) {
        this.getId().setTrainee(trainee);
    }

    public Trainee getTrainee() {
        return this.getId().getTrainee();
    }
}