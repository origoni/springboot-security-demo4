package com.millky.demo.security.four;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Email
    @Size(min = 5, max = 255)
    private String email;

    @Size(min = 5, max = 32)
    @Id
    @Column(length = 32)
    private String username;

    @Size(min = 5, max = 255)
    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;
}