package com.yezan.otraining.repository;

import com.yezan.otraining.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    List<Training> findByTitleContainingIgnoreCase(String title);
}
