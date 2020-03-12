package com.yezan.otraining.service;

import com.yezan.otraining.entity.Training;
import com.yezan.otraining.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository repository;

    public TrainingServiceImpl(TrainingRepository repository) {
        this.repository = repository;
    }

    public List<Training> get() {
        List<Training> trainings = new ArrayList<>();
        Iterable<Training> results = this.repository.findAll();
        results.forEach(trainings::add);
        return trainings;
    }

    public Training create(Training training) {
        return this.repository.save(training);
    }

    public Training update(Training training) {
        return this.repository.save(training);
    }

    public Training find(int id) {
        Optional<Training> optionalResult = this.repository.findById(id);
        if (!optionalResult.isPresent()) {
            throw new EntityNotFoundException("Training [" + id + "] not found");
        }

        return optionalResult.get();
    }

    public void delete(Training training) {
        this.repository.delete(training);
    }

    public void delete(int id) {
        Training training = this.find(id);
        this.delete(training);
    }

    public List<Training> search(String title) {
        List<Training> trainings = this.repository.findByTitleContainingIgnoreCase(title);
        return trainings;
    }
}
