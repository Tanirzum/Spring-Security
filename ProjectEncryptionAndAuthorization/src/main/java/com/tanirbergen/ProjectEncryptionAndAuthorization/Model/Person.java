package com.tanirbergen.ProjectEncryptionAndAuthorization.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "year")
    private int year;
    @Column(name = "role")
    private String role;
}
