package com.tozzr.reqif.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository {

	public static final String ROOT = "upload-dir";
	
	public Iterable<Project> findAll() throws IOException {
		ArrayList<Project> projects = new ArrayList<Project>();
		for (Link link : Files.walk(Paths.get(ROOT))
		.filter(path -> !path.equals(Paths.get(ROOT)))
		.map(path -> Paths.get(ROOT).relativize(path))
		.map(path -> linkTo(methodOn(FileUploadController.class).getFile(path.toString())).withRel(path.toString()))
		.collect(Collectors.toList())) {		
			Project p = new Project();
			p.id = "myId";
			p.name = link.getRel().split(".reqif")[0];
			projects.add(p);
		}
		return projects;
	}

}
