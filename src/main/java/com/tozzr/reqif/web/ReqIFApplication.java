package com.tozzr.reqif.web;

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
			Project project = new Project("RMT", "Requirements Management Tool");
//			Specification spec = new Specification(CRS, project);
//			spec.setText("Das System muss mehre Anforderungen in Projekten gruppiert erfassen können.");
//			spec.setExamples("Projekt 1, ..., Projekt N");
//			project.getSpecs().add(spec);
//			
//			spec = new Specification(CRS, project);
//			spec.setText("Das System muss mehrere unterschiedliche Anforderungstypen unterstützen.");
//			spec.setExamples("Lasten: CRS, Pflichten: SRS, SAR");
//			project.getSpecs().add(spec);
//			
//			spec = new Specification(CRS, project);
//			spec.setText("Das System muss Anforderungen eindeutig durch einen Schlüssel wiedererkennbar machen.");
//			spec.setExamples("Zum Beispiel zusammengesetzt aus Type und fortlaufende Nummer");
//			project.getSpecs().add(spec);
//			
//			spec = new Specification(CRS, project);
//			spec.setText("Das System muss Anforderungen verlinken können.");
//			spec.setExamples("Bezug auf übergeordnete Anforderung (Tracebility)");
//			project.getSpecs().add(spec);
//
//			spec = new Specification(CRS, project);
//			spec.setText("Das System muss jeder Änderung einer Anforderungen eine neue Version anlegen.");
//			spec.setExamples("Historie");
//			project.getSpecs().add(spec);
//			
//			Specification spec1 = Specification.version(spec);
//			spec1.setText("Das System muss die Versionierung von Anforderungen unterstützen.");
//			project.getSpecs().add(spec1);
//			
			repository.save(project);
		};
	}
}
