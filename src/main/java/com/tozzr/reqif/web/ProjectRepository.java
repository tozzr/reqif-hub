package com.tozzr.reqif.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class ProjectRepository {

	private String ROOT = "upload-dir";
	
	public void setBaseDir(String baseDir) {
		ROOT = baseDir;
	}

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

	public String save(MultipartFile file) throws IOException {
		Files.createDirectory(Paths.get(ROOT));
		String id = UUID.randomUUID().toString();
		Path dir = Paths.get(ROOT, id);
		Files.createDirectory(dir);
		Files.copy(file.getInputStream(), Paths.get(dir.toString(), "data.reqif"), StandardCopyOption.REPLACE_EXISTING);
		return id;
	}

	public Project find(String id) throws IOException {
		Project p = new Project();
		Path dir = Paths.get(ROOT);
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				return FileVisitResult.CONTINUE;
			}
	
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				if (Files.isDirectory(dir) && dir.endsWith(id)) {
					p.id = id;
				}
				return FileVisitResult.CONTINUE;
			}
	
		});
		return p;
	}

}
