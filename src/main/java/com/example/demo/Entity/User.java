package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;

    @NotBlank
    private String username;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @ElementCollection // stores this element to a separate table
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    ) //The @CollectionTable annotation is used to specify the name of the table that stores all the records of the collection, and the JoinColumn that refers to the primary table.
    @Column(name = "role")
    private Set<String> role;

    public User(String name, String username, String email, String password, Set<String> role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
