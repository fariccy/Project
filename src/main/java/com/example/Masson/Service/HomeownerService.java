package com.example.Masson.Service;

import com.example.Masson.Models.Homeowner;
import com.example.Masson.Repository.HomeownerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeownerService {





        @Autowired
        private HomeownerRepository repository;

        public List<Homeowner> getAllCustomer() {
            return repository.findAll();
        }

        public Optional<Homeowner> getCustomerById(Long id) {
            return repository.findById(id);
        }

        public Homeowner createCustomer(Homeowner customer) {
            Homeowner Customer = new Homeowner();
            return repository.save(Customer);
        }

        public Homeowner updateCustomer(Long id, Homeowner updatedCustomer) {
            return repository.findById(id)
                    .map(homeowner -> {
                        homeowner.setName(updatedCustomer.getName());
                        homeowner.setAddress(updatedCustomer.getAddress());
                        homeowner.setContactInfo(updatedCustomer.getContactInfo());
                        return repository.save(homeowner);
                    })
                    .orElseThrow(() -> new RuntimeException("Homeowner not found"));
        }

        public void deleteHomeowner(Long id) {
            repository.deleteById(id);
        }

}

