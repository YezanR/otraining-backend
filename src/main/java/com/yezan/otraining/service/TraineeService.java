package com.yezan.otraining.service;

import com.yezan.otraining.entity.Trainee;
import java.util.List;

public interface TraineeService {
    List<Trainee> findAll();
    Trainee find(int id);
}


