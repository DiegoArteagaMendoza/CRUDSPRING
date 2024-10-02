package com.crud.CRUD.Projects;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void createProject(Project project) {
        if (project != null) {
            projectRepository.save(project);
        } else {
            System.out.println("Error al crear el proyecto");
        }
    }

    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }

    public Optional<Project> findProjectById(int id) {
        return projectRepository.findById(id);
    }

    public boolean deleteProject(int id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        } else {
            System.out.println("El proyecto no existe");
            return false;
        }
    }

    public Project updateNombre(int id, String newNombre) {
        return projectRepository.findById(id).map(project -> {
            project.setProjectNombre(newNombre);
            return projectRepository.save(project);
        }).orElseThrow(() -> new RuntimeException("Proyecto no encontrado" + id));
    }

}
