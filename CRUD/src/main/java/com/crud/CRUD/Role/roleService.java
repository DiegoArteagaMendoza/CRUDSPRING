package com.crud.CRUD.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class roleService {

    @Autowired
    private roleRepository roleRepository;

    // Obtener todos los roles
    public List<role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Obtener un rol por ID
    public Optional<role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    // Guardar un nuevo rol
    public role saveRole(role role) {
        return roleRepository.save(role);
    }

    // Actualizar un rol
    public role updateRole(Integer id, role roleDetails) {
        role role = roleRepository.findById(id).orElseThrow();
        role.setRoleType(roleDetails.getRoleType());
        return roleRepository.save(role);
    }

    // Eliminar un rol
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
