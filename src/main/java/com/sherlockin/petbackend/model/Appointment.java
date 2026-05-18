package com.sherlockin.petbackend.model;


import java.time.LocalDateTime;

import com.sherlockin.petbackend.model.enums.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String reason;

    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @OneToOne
    private Pet pet;

    @OneToOne
    private User veterinarian;

}
