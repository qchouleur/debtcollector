package controllers;


import java.util.ArrayList;
import java.util.List;

import models.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.StaticDataStorage;


@Controller
@RequestMapping(value = {"/", "/index"})
public class PlanController {

	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	private MessageSource messageSource;
	private StaticDataStorage data = new StaticDataStorage();
	private Plan plan = data.getPlan();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Mandatory, otherwise the contact model validation keep 
		// failing because of string to Id conversion
		binder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		model.addAttribute("plans", plan);
		
		return "index";

	}
}

