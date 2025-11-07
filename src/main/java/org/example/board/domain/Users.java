package org.example.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false,  length = 50)
    private String username;

    @Column(nullable = false,  length = 100)
    private String password;

    @Column(unique = true,  nullable = false,  length = 50)
    private String email;

    private String role;
}
