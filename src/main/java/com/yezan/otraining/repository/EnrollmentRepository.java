package com.yezan.otraining.repository;

import com.yezan.otraining.entity.Enrollment;
import com.yezan.otraining.entity.EnrollmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, EnrollmentId> {
}
