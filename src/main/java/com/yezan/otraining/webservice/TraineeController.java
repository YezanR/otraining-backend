package com.yezan.otraining.webservice;

import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.service.TraineeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "trainees")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Trainee> get() {
        return this.traineeService.findAll();
    }
}
