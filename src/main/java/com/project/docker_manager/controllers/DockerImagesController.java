package com.project.docker_manager.controllers;

import com.github.dockerjava.api.model.Image;
import com.project.docker_manager.services.DockerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@Tag(name = "Images", description = "Docker image management")
public class DockerImagesController {

    private final DockerService dockerService;

    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("")
    @Operation(description = "Listing docker images",
            summary = "All images")
    public List<Image> listImages() {
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    @Operation(description = "List of images filtered by name",
            summary = "Filtered image")
    public List<Image> listImages(@RequestParam(required = false, defaultValue = "image-") String filterName) {
        return dockerService.filterImages(filterName);
    }
}
