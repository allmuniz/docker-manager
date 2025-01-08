package com.project.docker_manager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Docker Manage",
				description = "API responsible for managing docker images and containers",
				version = "1"
		)
)
public class DockerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerManagerApplication.class, args);
	}

}
