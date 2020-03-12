package com.yezan.otraining.service;

import com.yezan.otraining.entity.Enrollment;
import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.entity.Training;

public interface EnrollmentService {
    Enrollment enroll(Trainee trainee, Training training);
    Enrollment find(Trainee trainee, Training training);
    boolean isEnrolled(Trainee trainee, Training training);
}
