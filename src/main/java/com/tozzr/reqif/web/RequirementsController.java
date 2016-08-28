package com.tozzr.reqif.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequirementsController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/requirements", method=RequestMethod.GET)
	public @ResponseBody List<Requirement> getRequirements() {
		List<Requirement> reqs = new ArrayList<Requirement>();
		reqs.add(new Requirement());
		return reqs;
	}
	
	class Requirement {
		public int system = 0;
		public int priority = 1;
		public int type = 0;
		public String object = "";
		public String processword = "";
	}
}
