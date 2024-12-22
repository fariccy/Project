package com.example.Masson.Controler;


import com.example.Masson.Models.MaintenanceRecord;
import com.example.Masson.Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professional")

public class MaintenanceControler {


        @Autowired
        private MaintenanceService service;

        @GetMapping
        public List<MaintenanceRecord> getAllRecords() {
            return service.getAllRecords();
        }

        @GetMapping("/{id}")
        public ResponseEntity<MaintenanceRecord> getRecordById(@PathVariable Long id) {
            return service.getRecordById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public MaintenanceRecord createRecord(@RequestBody MaintenanceRecord record) {
            return service.createRecord(record);
        }

        @PutMapping("/{id}")
        public ResponseEntity<MaintenanceRecord> updateRecord(@PathVariable Long id, @RequestBody MaintenanceRecord updatedRecord) {
            try {
                return ResponseEntity.ok(service.updateRecord(id, updatedRecord));
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
            service.deleteRecord(id);
            return ResponseEntity.noContent().build();
        }
}