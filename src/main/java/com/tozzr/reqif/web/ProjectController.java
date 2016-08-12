package com.tozzr.reqif.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@ModelAttribute("projects")
	public Iterable<Project> populateProjects() throws IOException {
		return projectRepository.findAll();
	}
	
	@RequestMapping(method=GET)
    public String projects() {
        return "projects";
    }
	
	@RequestMapping(method=GET, value="/form")
    public String projectForm() {
        return "uploadForm";
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/form")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
								   RedirectAttributes redirectAttributes) {

		int MAX_FILE_SIZE = 15 * 1024 * 1024;

		if (file.isEmpty()){
			redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
		} else if (file.getSize() >= MAX_FILE_SIZE) {
			redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was too big");
		} else {
			try {
				projectRepository.save(file);
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + file.getOriginalFilename() + "!");
			} catch (IOException|RuntimeException e) {
				redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
			}
		}

		return "redirect:/projects/form";
	}
	
	@RequestMapping(method=GET, value="/{id}")
    public ModelAndView getProjectForm(@PathVariable("id") String id) throws IOException {
		ModelAndView mav = new ModelAndView("project");
		mav.addObject("project", projectRepository.find(id));
		return mav;
    }
}
