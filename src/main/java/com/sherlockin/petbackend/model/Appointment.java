package com.sherlockin.petbackend.model;

import com.sherlockin.petbackend.model.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

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
