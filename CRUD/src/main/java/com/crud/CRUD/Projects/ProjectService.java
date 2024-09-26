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

    public List<Project>findAllProject() {
        return projectRepository.findAll();
    }

    

}
