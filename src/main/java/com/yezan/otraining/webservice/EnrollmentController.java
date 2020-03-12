package com.yezan.otraining.webservice;

import com.yezan.otraining.entity.Enrollment;
import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.entity.Training;
import com.yezan.otraining.service.EnrollmentService;
import com.yezan.otraining.service.TraineeService;
import com.yezan.otraining.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final TrainingService trainingService;
    private final TraineeService traineeService;

    public EnrollmentController(EnrollmentService enrollmentService,
                                TrainingService trainingService,
                                TraineeService traineeService) {
        this.enrollmentService = enrollmentService;
        this.trainingService = trainingService;
        this.traineeService = traineeService;
    }

    @RequestMapping(value = "enrollments", method = RequestMethod.POST)
    public ResponseEntity<Enrollment> enroll(@RequestBody EnrollmentRequest enrollmentRequest) {
        int traineeId = enrollmentRequest.getTraineeId();
        int trainingId = enrollmentRequest.getTrainingId();

        try {
            Training training = this.trainingService.find(trainingId);
            Trainee trainee = this.traineeService.find(traineeId);
            Enrollment enrollment = this.enrollmentService.enroll(trainee, training);
            return ResponseEntity.ok(enrollment);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
        catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, exception.getMessage());
        }
    }
}

class EnrollmentRequest {
    private int traineeId;
    private int trainingId;

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
}
