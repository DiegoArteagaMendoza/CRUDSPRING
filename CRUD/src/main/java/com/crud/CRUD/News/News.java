
package com.crud.CRUD.News;

import java.time.LocalDateTime;

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
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 255)
    private String titulo;
    @Column(nullable = false, length = 255)
    private String encabezado;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String cuerpo;
    @Column(nullable = false)
    private LocalDateTime fechaPublicacion;
    @Column(nullable = false, length = 100)
    private String autor;


}

