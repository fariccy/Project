package com.example.Masson.Service;


import com.example.Masson.Models.Contractors;
import com.example.Masson.Repository.ConstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ConstService {


        @Autowired
        private ConstRepository repository;

        public List<Contractors> getAllContractors() {
            return repository.findAll();
        }

        public Optional<Contractors> getContractorById(Long id) {
            return repository.findById(id);
        }

        public Contractors createContractor(Contractors contractors) {
            return repository.save(contractors);
        }

        public Contractors updateContractor(Long id, Contractors updatedContractor) {
            return repository.findById(id)
                    .map(contractor -> {
                        contractor.setName(updatedContractor.getName());
                        contractor.setContactInfo(updatedContractor.getContactInfo());
                        contractor.setSpecialization(updatedContractor.getSpecialization());
                        return repository.save(contractor);
                    })
                    .orElseThrow(() -> new RuntimeException("Contractor not found"));
        }

        public void deleteContractor(Long id) {
            repository.deleteById(id);
        }
}
