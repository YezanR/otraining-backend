package com.yezan.otraining.service;

import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.entity.Training;

public class TraineeAlreadyEnrolledException extends RuntimeException {

    private Trainee trainee;
    private Training training;

    public TraineeAlreadyEnrolledException(Trainee trainee, Training training) {
        this.trainee = trainee;
        this.training = training;
    }

    @Override
    public String getMessage() {
        return "Trainee [" + this.trainee.getId() + "]" +
                " is already enrolled in the training [" + this.training.getId() + "]";
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
