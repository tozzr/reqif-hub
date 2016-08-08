package com.tozzr.reqif.web;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private SpecificationRepository specificationRepository;
	
	@ModelAttribute("projects")
	public Iterable<Project> populateProjects() {
		return projectRepository.findAll();
	}
	
	@RequestMapping(method=GET)
    public String projects() {
        return "projects";
    }
	
    @RequestMapping(value="/{id}", method=GET)
    public String project(@PathVariable("id") Long id, Model model) {
    	Project project = projectRepository.findOne(id);
		model.addAttribute("project", project);
        return "project";
    }

    @RequestMapping(value="/{id}/specs/form", method=GET)
    public String specsForm(@PathVariable("id") long id, Model model) {
    	Project project = projectRepository.findOne(id);
		model.addAttribute("project", project);
    	model.addAttribute("spec", new Specification());
        return "spec";
    }
    
    @RequestMapping(value="/{id}/specs/form", method=POST)
    public String createSpec(@PathVariable("id") long id, Specification spec, Model model) {
		Project project = projectRepository.findOne(id);
		Specification s = new Specification(spec.getType(), project);
		s.setText(spec.getText());
		s.setType(SpecificationType.CRS);
		specificationRepository.save(s);
		return "redirect:/projects/" + id;
    }
    
    @RequestMapping(value="/{id}/specs/{specId}", method=GET)
    public String specs(@PathVariable("id") long id, @PathVariable("specId") long specId, Model model) {
    	Project project = projectRepository.findOne(id);
		model.addAttribute("project", project);
    	model.addAttribute("spec", findSpec(project, specId));
        return "spec";
    }

	private Specification findSpec(Project project, long id) {
		for (Specification s : project.getSpecs())
			if (s.getId() == id)
				return s;
		return null;
	}
	
	@RequestMapping(value="/{id}/specs/{specId}", method=POST)
    public String updateSpec(@PathVariable("id") long id, @PathVariable("specId") long specId, Specification spec, Model model) {
		Project project = projectRepository.findOne(id);
		Specification s = findSpec(project, specId);
		s.setType(spec.getType());
		s.setText(spec.getText());
		projectRepository.save(project);
		return "redirect:/projects/" + id;
    }
	
	@RequestMapping(value="/{id}/specs/{specId}", method=DELETE)
    public String deleteSpec(@PathVariable("id") long id, @PathVariable("specId") long specId) {
		Project project = projectRepository.findOne(id);
		Specification s = findSpec(project, specId);
		System.out.println("delete " + s);
		project.getSpecs().remove(s);
		projectRepository.save(project);
		return "redirect:/projects/" + id;
    }
}
