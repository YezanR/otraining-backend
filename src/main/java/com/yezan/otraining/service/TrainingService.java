package com.yezan.otraining.service;

import com.yezan.otraining.entity.Training;
import java.util.List;

public interface TrainingService {
    List<Training> get();
    Training create(Training training);
    Training update(Training training);
    Training find(int id);
    void delete(Training training);
    void delete(int id);
    List<Training> search(String title);
}
