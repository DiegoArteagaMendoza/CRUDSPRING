package com.crud.CRUD.Projects;

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

import com.crud.CRUD.News.News;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // crear proyecto
    @PostMapping("/create")
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    // buscar proyecto
    @GetMapping("/search")
    public List<Project> findAllProjects() {
        return projectService.findAllProject();
    }

    // buscar proyecto por id
    @GetMapping("/search/{id}")
    public Optional<Project> findProjectById(@PathVariable int id) {
        return projectService.findProjectById(id);
    }

    // eliminar proyecto
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
        boolean isDeleted = projectService.deleteProject(id);
        if (isDeleted) {
            return ResponseEntity.ok("Proyecto eliminado exitosamente");
        } else {
            return ResponseEntity.status(404).body("Proyecto no encontrado");
        }
    }

    // modificar nombre del proyecto por id
    @PutMapping("updateName/{id}")
    public ResponseEntity<Project> updateTitular(@PathVariable int id, @RequestBody String newTitulo) {
        try {
            Project updatedProject = projectService.updateNombre(id, newTitulo);
            return ResponseEntity.ok(updatedProject);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

}
