package com.crud.CRUD.Password;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class passwordService {

    @Autowired
    private passwordRepository passwordRepository;

    // Obtener todas las contraseñas
    public List<password> getAllPasswords() {
        return passwordRepository.findAll();
    }

    // Obtener una contraseña por ID
    public Optional<password> getPasswordById(Integer id) {
        return passwordRepository.findById(id);
    }

    // Guardar una nueva contraseña
    public password savePassword(password password) {
        return passwordRepository.save(password);
    }

    // Actualizar una contraseña
    public password updatePassword(Integer id, password passwordDetails) {
        password password = passwordRepository.findById(id).orElseThrow();
        password.setPass(passwordDetails.getPass());
        return passwordRepository.save(password);
    }

    // Eliminar una contraseña
    public void deletePassword(Integer id) {
        passwordRepository.deleteById(id);
    }
}
