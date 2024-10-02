package com.crud.CRUD.Password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passwords")
public class passwordController {

    @Autowired
    private passwordService passwordService;

    // Obtener todas las contraseñas
    @GetMapping
    public List<password> getAllPasswords() {
        return passwordService.getAllPasswords();
    }

    // Obtener una contraseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<password> getPasswordById(@PathVariable Integer id) {
        return passwordService.getPasswordById(id)
                .map(password -> ResponseEntity.ok().body(password))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva contraseña
    @PostMapping
    public password createPassword(@RequestBody password password) {
        return passwordService.savePassword(password);
    }

    // Actualizar una contraseña
    @PutMapping("/{id}")
    public ResponseEntity<password> updatePassword(@PathVariable Integer id, @RequestBody password passwordDetails) {
        password updatedPassword = passwordService.updatePassword(id, passwordDetails);
        return ResponseEntity.ok(updatedPassword);
    }

    // Eliminar una contraseña
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Integer id) {
        passwordService.deletePassword(id);
        return ResponseEntity.noContent().build();
    }
}
