package com.crud.CRUD.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // crear usuarios
    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    // eliminar usuarios
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("Usuario eliminado existosamente");
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
    }

    // buscar todos los usuarios
    @GetMapping("/search")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    // buscar usuario por rut
    @GetMapping("/search/rut/{rut}")
    public Optional<User> findUserByRut(@PathVariable String rut) {
        System.out.println(rut);
        Optional<User> user = userService.findUserByRut(rut);
        if (user.isPresent()) {
            return user;
        } else {
            return null;
        }
    }

    // buscar usuario por id
    @GetMapping("/search/{id}")
    public Optional<User> findUserById(@PathVariable int id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return user;
        } else {
            return null;
        }
    }

    // modificar email usuario por id
    // @PutMapping("/updateEmail/{id}")
    // public ResponseEntity<User> updateUserEmail(@PathVariable int id, @RequestBody String newEmail) {
    //     try {
    //         User updatedUser = userService.updateUserEmail(id, newEmail);
    //         return ResponseEntity.ok(updatedUser); // Retorna el usuario actualizado
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.status(404).body(null); // Retorna 404 si no encuentra el usuario
    //     }
    // }
}
