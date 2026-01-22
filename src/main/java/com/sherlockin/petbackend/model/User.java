package com.sherlockin.petbackend.model;

import com.sherlockin.petbackend.model.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String username;

    @Column (unique = true)
    private String phone;
    private String password;
    private String fistName;
    private String lastName;
    private String address;

    @OneToMany
    private List<Pet> pet;

    @Enumerated
    private Set<Role> role;

}
