package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.model.FAQ;
import org.generation.italy.EpicTrip.model.repository.abstraction.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public interface FAQService {
    List<FAQ> findAllFaq();
}
