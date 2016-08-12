package com.tozzr.reqif.web;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

public class ProjectRepositoryTest {

	String baseDir = "test-dir";
	String fileName = "data.reqif";
	
	int found;
	private ProjectRepository repository;

	@Before
	public void setUp() throws Exception {
		repository = new ProjectRepository();
		repository.setBaseDir("test-dir");
	}
	
	@After
	public void tearDown() throws Exception {
	   Path directory = Paths.get(baseDir);
	   Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
		   @Override
		   public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			   Files.delete(file);
			   return FileVisitResult.CONTINUE;
		   }

		   @Override
		   public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			   Files.delete(dir);
			   return FileVisitResult.CONTINUE;
		   }

	   });
	}
	
	private void assertDirIsEmpy() {
		assertFalse(Files.isDirectory(Paths.get(baseDir)));
	}

	private void assertDirIsNotEmpty() throws IOException {
		Path dir = Paths.get(baseDir);
		assertTrue(Files.isDirectory(dir));
		found = 0;
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.endsWith(fileName))
					found++;
				return FileVisitResult.CONTINUE;
			}
	
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				if (Files.isDirectory(dir))
					return FileVisitResult.CONTINUE;
				else
					return FileVisitResult.SKIP_SUBTREE;
			}
	
		});
		assertEquals(1, found);
	}

	@Test
	public void save() throws IOException {
		assertDirIsEmpy();
		
		repository.save(new MockMultipartFile("filename", "some content".getBytes()));
		
		assertDirIsNotEmpty();
	}
	
	@Test
	public void find() throws Exception {
		String id = repository.save(new MockMultipartFile("filename", "some content".getBytes()));
		Project project = repository.find(id);
		assertThat(project.id, equalTo(id));
	}

}
