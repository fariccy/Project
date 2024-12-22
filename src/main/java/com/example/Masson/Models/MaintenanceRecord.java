package com.example.Masson.Models;

import jakarta.persistence.*;
@Entity
@Table(name = "maintenance_records")
public class MaintenanceRecord {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "homeowner_id", nullable = false)
        private Homeowner customer;

        @Column(name = "service_date", nullable = false)
        private String serviceDate;

        @ManyToOne
        @JoinColumn(name = "contractor_id", nullable = false)
        private Contractors contractors;

        @Column(name = "service_type", nullable = false)
        private String serviceType;

        @Column(name = "contractor_name", nullable = false)
        private String contractorName;

        // Constructors
        public void Customer() {
        }

        public MaintenanceRecord(Homeowner customer, String serviceDate, String serviceType, String contractorName) {
            this.customer = customer;
            this.serviceDate = serviceDate;
            this.serviceType = serviceType;
            this.contractorName = contractorName;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Homeowner getCustomer() {
            return customer;
        }

        public void setCustomer(Homeowner customer) {
            this.customer = customer;
        }

        public String getServiceDate() {
            return serviceDate;
        }

        public void setServiceDate(String serviceDate) {
            this.serviceDate = serviceDate;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getContractorName() {
            return contractorName;
        }

        public void setContractorName(String contractorName) {
            this.contractorName = contractorName;
        }

        public Contractors getArchitet() {
            return contractors;
        }

        public void setContractor(Contractors contractors) {
            this.contractors = contractors;
        }
}


