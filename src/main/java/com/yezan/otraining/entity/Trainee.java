package com.yezan.otraining.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("3")
public class Trainee extends User {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "trainees")
    private List<Training> trainings = new ArrayList<>();
}
