package com.example.Masson.Service;


import com.example.Masson.Models.MaintenanceRecord;
import com.example.Masson.Repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaintenanceService {



        @Autowired
        private MaintenanceRepository repository;

        public List<MaintenanceRecord> getAllRecords() {
            return repository.findAll();
        }

        public Optional<MaintenanceRecord> getRecordById(Long id) {
            return repository.findById(id);
        }

        public MaintenanceRecord createRecord(MaintenanceRecord record) {
            return repository.save(record);
        }

        public MaintenanceRecord updateRecord(Long id, MaintenanceRecord updatedRecord) {
            return repository.findById(id)
                    .map(record -> {
                        record.setCustomer(updatedRecord.getCustomer());
                        record.setCustomer(updatedRecord.getCustomer());
                        record.setServiceDate(updatedRecord.getServiceDate());
                        record.setServiceType(updatedRecord.getServiceType());
                        record.setContractorName(updatedRecord.getContractorName());
                        return repository.save(record);
                    })
                    .orElseThrow(() -> new RuntimeException("Professional Record not found"));
        }

        public void deleteRecord(Long id) {
            repository.deleteById(id);
        }
}
