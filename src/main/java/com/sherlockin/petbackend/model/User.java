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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;
    private String email;
    private String phone;
    private String password;
    private String firstName;
    private String lastName;
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    //Numerando o Enum em ordem
    @Enumerated(EnumType.STRING)
    //Deixando claro que o elementCollection esta apontando para o enum Role
    @ElementCollection(targetClass = Role.class)
    //os elementos do atributo abaixo ficam na tabela "user_roles"
    @CollectionTable(name = "user_roles",
            //e ele liga a essa classe (user) pelo "user_id"
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Role> role;

}
