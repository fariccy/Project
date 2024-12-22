package com.example.Masson.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "homeowners")
public class Homeowner {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "contact_info", nullable = false)
        private String contactInfo;

        // Constructors
        public Homeowner() {
        }

        public Homeowner(String name, String address, String contactInfo) {
            this.name = name;
            this.address = address;
            this.contactInfo = contactInfo;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }
}

