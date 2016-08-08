package com.tozzr.reqif.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@ModelAttribute("projects")
	public Iterable<Project> populateProjects() {
		return projectRepository.findAll();
	}
	
	@RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
	
}
