package com.tozzr.reqif.web;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReqIFApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReqIFApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProjectRepository repository) {
		return (args) -> {
			if (!Files.exists(Paths.get(FileUploadController.ROOT)))
				Files.createDirectory(Paths.get(FileUploadController.ROOT));
		};
	}
}
