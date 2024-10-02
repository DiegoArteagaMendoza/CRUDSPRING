package com.crud.CRUD.Password;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface passwordRepository extends JpaRepository<password, Integer> {
    // Métodos adicionales de consulta pueden ser agregados aquí si es necesario
}
