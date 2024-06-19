package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FAQRepository extends JpaRepository<FAQ,Long> {
}

