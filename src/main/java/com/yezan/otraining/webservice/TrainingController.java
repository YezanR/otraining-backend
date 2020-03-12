package com.yezan.otraining.webservice;

import com.yezan.otraining.entity.Trainer;
import com.yezan.otraining.entity.Training;
import com.yezan.otraining.service.TrainerService;
import com.yezan.otraining.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("trainings")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainerService trainerService;

    public TrainingController(TrainingService trainingService, TrainerService trainerService) {
        this.trainingService = trainingService;
        this.trainerService = trainerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Training> get() {
        return this.trainingService.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Training> find(@PathVariable int id) {
        try {
            Training training = this.trainingService.find(id);
            return ResponseEntity.ok(training);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Training create(@RequestBody WriteRequest requestParam) {
        Training training = new Training();
        training.setTitle(requestParam.getTitle());
        training.setDuration(requestParam.getDuration());
        try {
            requestParam.getTrainerId().ifPresent((trainerId) -> {
                Trainer trainer = this.trainerService.find(trainerId);
                training.setTrainer(trainer);
            });
            return this.trainingService.create(training);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Training> update(@PathVariable int id, @RequestBody WriteRequest requestParam) {
        try {
            Training training = this.trainingService.find(id);
            training.setTitle(requestParam.getTitle());
            training.setDuration(requestParam.getDuration());
            training.setId(id);
            requestParam.getTrainerId().ifPresent((trainerId) -> {
                Trainer trainer = this.trainerService.find(trainerId);
                training.setTrainer(trainer);
            });
            Training updatedTraining = this.trainingService.update(training);
            return ResponseEntity.ok(updatedTraining);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        try {
            this.trainingService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Training> search(@RequestParam String title) {
        return this.trainingService.search(title);
    }
}

class WriteRequest {
    private String title;
    private int duration;
    private Integer trainerId;

    public Optional<Integer> getTrainerId() {
        return Optional.ofNullable(trainerId);
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}