package com.yezan.otraining.service;

import com.yezan.otraining.entity.Trainer;
import com.yezan.otraining.repository.TrainerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    private final PasswordEncoder passwordEncoder;

    public TrainerServiceImpl(TrainerRepository trainerRepository, PasswordEncoder passwordEncoder) {
        this.trainerRepository = trainerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Trainer> findAll() {
        List<Trainer> trainers = new ArrayList<>();
        Iterable<Trainer> results = this.trainerRepository.findAll();
        results.forEach(trainers::add);
        return trainers;
    }

    @Override
    public Trainer create(Trainer trainer) {
        String password = this.passwordEncoder.encode(trainer.getPassword());
        trainer.setPassword(password);
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer update(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer find(int id) {
        Optional<Trainer> maybeTrainer = this.trainerRepository.findById(id);
        if (!maybeTrainer.isPresent()) {
            throw new EntityNotFoundException("Traineer [" + id + "] not found");
        }

        return maybeTrainer.get();
    }

    @Override
    public void delete(Trainer trainer) {
        this.trainerRepository.delete(trainer);
    }

    @Override
    public void delete(int id) {
        Trainer trainer = this.find(id);
        this.delete(trainer);
    }
}
