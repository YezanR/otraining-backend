package com.yezan.otraining.service;

import com.yezan.otraining.entity.Enrollment;
import com.yezan.otraining.entity.EnrollmentId;
import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.entity.Training;
import com.yezan.otraining.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enroll(Trainee trainee, Training training) {
        if (this.isEnrolled(trainee, training)) {
            throw new TraineeAlreadyEnrolledException(trainee, training);
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setTraining(training);
        enrollment.setTrainee(trainee);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        return this.enrollmentRepository.save(enrollment);
    }

    public Enrollment find(Trainee trainee, Training training) {
        EnrollmentId id = new EnrollmentId(training, trainee);
        Optional<Enrollment> optionalResult = this.enrollmentRepository.findById(id);
        return optionalResult.orElse(null);
    }

    public boolean isEnrolled(Trainee trainee, Training training) {
        return this.find(trainee, training) != null;
    }
}
