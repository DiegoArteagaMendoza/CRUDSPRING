package com.crud.CRUD.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class roleController {

    @Autowired
    private roleService roleService;

    // Obtener todos los roles
    @GetMapping
    public List<role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<role> getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id)
                .map(role -> ResponseEntity.ok().body(role))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo rol
    @PostMapping
    public role createRole(@RequestBody role role) {
        return roleService.saveRole(role);
    }

    // Actualizar un rol
    @PutMapping("/{id}")
    public ResponseEntity<role> updateRole(@PathVariable Integer id, @RequestBody role roleDetails) {
        role updatedRole = roleService.updateRole(id, roleDetails);
        return ResponseEntity.ok(updatedRole);
    }

    // Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
