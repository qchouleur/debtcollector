package controllers;

import javax.validation.Valid;

import models.Person;
import models.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import data.StaticDataStorage;

@Controller
@RequestMapping("/persons")
public class PersonController {

	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	public MessageSource messageSource;
	public StaticDataStorage data = new StaticDataStorage();
	public Plan plan = data.getPlan();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Mandatory, otherwise the contact model validation keep 
		// failing because of string to Id conversion
		binder.setDisallowedFields("id");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		model.addAttribute("users", data.getUsers());
		
		return "persons/list";

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(ModelMap model) {
		
		return new ModelAndView("persons/create", "person", new Person());
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(
			@ModelAttribute("person") @Valid Person person,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("persons/list");
		}
		
		data.addPerson(person);
		
		return new ModelAndView("redirect:/persons/list/");
	}
}
