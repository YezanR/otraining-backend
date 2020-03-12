package com.yezan.otraining.service;

import com.yezan.otraining.entity.Trainer;
import java.util.List;

public interface TrainerService {
    List<Trainer> findAll();
    Trainer create(Trainer trainer);
    Trainer update(Trainer trainer);
    Trainer find(int id);
    void delete(Trainer trainer);
    void delete(int id);
}
