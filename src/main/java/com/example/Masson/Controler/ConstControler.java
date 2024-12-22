package com.example.Masson.Controler;


import com.example.Masson.Models.Contractors;
import com.example.Masson.Service.ConstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractors")

public class ConstControler {


        @Autowired
        private ConstService service;

        @GetMapping
        public List<Contractors> getAllContractors() {
            return service.getAllContractors();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Contractors> getContractorById(@PathVariable Long id) {
            return service.getContractorById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public Contractors createContractor(@RequestBody Contractors contractors) {
            return service.createContractor(contractors);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Contractors> updateContractor(@PathVariable Long id, @RequestBody Contractors updatedContractors) {
            try {
                return ResponseEntity.ok(service.updateContractor(id, updatedContractors));
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteContractor(@PathVariable Long id) {
            service.deleteContractor(id);
            return ResponseEntity.noContent().build();
        }
}
