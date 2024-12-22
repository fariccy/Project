package com.example.Masson.Models;

import jakarta.persistence.*;
@Entity
@Table(name = "contractors")
public class Contractors {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "contact_info", nullable = false)
        private String contactInfo;

        @Column(name = "specialization", nullable = false)
        private String specialization;

        // Constructors
        public Contractors() {
        }

        public Contractors(String name, String contactInfo, String specialization) {
            this.name = name;
            this.contactInfo = contactInfo;
            this.specialization = specialization;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }
}
