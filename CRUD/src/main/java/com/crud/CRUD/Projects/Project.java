package com.crud.CRUD.Projects;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 255)
    private String projectNombre;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String projectDescripcion;
    @Column(nullable = false)
    private Date fechaInicio;
    @Column(nullable = false)
    private Date fechaTermino;
    @Column(nullable = false, length = 100)
    private String autor;

}
