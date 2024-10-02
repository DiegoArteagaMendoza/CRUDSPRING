package com.crud.CRUD.Password;

import com.crud.CRUD.Users.User;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password")
public class password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassword;

    @Basic
    private String pass;

    // Relación con User (muchos passwords para un usuario)
    @ManyToOne
    @JoinColumn(name = "pass_is_user", referencedColumnName = "userId")
    private User user;
}
