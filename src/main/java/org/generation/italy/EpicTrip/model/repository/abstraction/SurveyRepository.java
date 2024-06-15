package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.Survey;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
    List<Survey> findAllByOrderById();
}
