package com.crud.CRUD.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role, Integer> {
    // Métodos adicionales de consulta pueden ser agregados aquí si es necesario
}
