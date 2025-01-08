package com.project.docker_manager.controllers;

import com.github.dockerjava.api.model.Container;
import com.project.docker_manager.services.DockerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
@Tag(name = "Containers", description = "Docker containers management")
public class DockerContainerController {

    private final DockerService dockerService;

    public DockerContainerController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("")
    @Operation(description = "Listing docker containers",
            summary = "All containers")
    public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll) {
        return dockerService.listContainers(showAll);
    }

    @PostMapping("")
    @Operation(description = "Creating docker containers from the docker image",
            summary = "Creating docker containers")
    public void createContainer(@RequestParam String imageName) {
        dockerService.createContainer(imageName);
    }

    @PostMapping("/{id}/start")
    @Operation(summary = "Start a container")
    public void startContainer(@PathVariable String id) {
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    @Operation(summary = "Stop a container")
    public void stopContainer(@PathVariable String id) {
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a container")
    public void deleteContainer(@PathVariable String id) {
        dockerService.deleteContainer(id);
    }
}
