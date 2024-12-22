package com.example.Masson.Controler;
import com.example.Masson.Models.Homeowner;
import com.example.Masson.Service.HomeownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class HomeownerControler {


        @Autowired
        private HomeownerService service;

        @GetMapping
        public List<Homeowner> getAllHomeowners() {
            return service.getAllCustomer();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Homeowner> getHomeownerById(@PathVariable Long id) {
            return service.getCustomerById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public Homeowner createHomeowner(@RequestBody Homeowner customer) {
            return service.createCustomer(customer);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Homeowner> updateHomeowner(@PathVariable Long id, @RequestBody Homeowner updatedHomeowner) {
            try {
                return ResponseEntity.ok(service.updateCustomer(id, updatedHomeowner));
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteHomeowner(@PathVariable Long id) {
            service.deleteHomeowner(id);
            return ResponseEntity.noContent().build();
        }
}


