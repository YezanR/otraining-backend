package com.yezan.otraining.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {

    @ManyToOne
    private Trainee trainee;

    @ManyToOne
    private Training training;

    public EnrollmentId() {

    }

    public EnrollmentId(Training training, Trainee trainee) {
        this.setTraining(training);
        this.setTrainee(trainee);
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
