package com.yezan.otraining.service;

import com.yezan.otraining.entity.Trainee;
import com.yezan.otraining.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<Trainee> findAll() {
        List<Trainee> trainees = new ArrayList<>();
        Iterable<Trainee> results = this.traineeRepository.findAll();
        results.forEach((trainee -> {trainees.add(trainee);}));
        return trainees;
    }

    public Trainee find(int id) {
        Optional<Trainee> optionalResult = this.traineeRepository.findById(id);
        if (!optionalResult.isPresent()) {
            throw new EntityNotFoundException("Trainee [" + id + "] not found");
        }

        return optionalResult.get();
    }
}
