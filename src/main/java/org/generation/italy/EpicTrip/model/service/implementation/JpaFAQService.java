package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.model.FAQ;
import org.generation.italy.EpicTrip.model.repository.abstraction.FAQRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaFAQService implements FAQService {
    private FAQRepository FaqRepo;

    @Autowired
    public JpaFAQService(FAQRepository FaqRepo){
        this.FaqRepo = FaqRepo;
    }

    @Override
    public List<FAQ> findAllFaq() {
        return FaqRepo.findAll();
    }
}
