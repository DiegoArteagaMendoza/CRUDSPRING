package com.crud.CRUD.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        if (user != null) {
            userRepository.save(user);
        } else {
            System.out.println("Error al crear el usuario");
        }
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByRut(String rut) {
        return userRepository.findUserByRut(rut);
    }

    // public User updateUserEmail(int id, String newEmail) {
    //     return userRepository.findById(id).map(user -> {
    //         // Actualizamos solo el campo de email
    //         user.setEmail(newEmail);
    //         return userRepository.save(user); // Guardamos el usuario actualizado
    //     }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    // }
    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUserName(userDetails.getUserName());
        user.setUserLastName(userDetails.getUserLastName());
        user.setUserPhone(userDetails.getUserPhone());
        user.setUserEmail(userDetails.getUserEmail());
        return userRepository.save(user);
    }

    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
