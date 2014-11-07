package controllers;

import java.util.List;

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

import service.PlanService;
import data.StaticDataStorage;

@Controller
@RequestMapping("/persons")
public class PersonController {

	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	public MessageSource messageSource;
	private PlanService service = StaticDataStorage.service();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		model.addAttribute("users", service.allPersons());
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
			return new ModelAndView("redirect:/persons/list");
		}
		
		for(Person per : service.allPersons())
		{
			if(per.getEmail().equals(person.getEmail()))
			{
				redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.person.email", null, null));
				return new ModelAndView("redirect:/persons/list");
			}
		}
		
		person.setId(Person.randInt(10, 9000000));
		//data.addPerson(person);
		service.update(person);
		
		return new ModelAndView("redirect:/persons/list/");
	}
	
	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable(value = "idPerson") String id) {
		
		int idPerson = Integer.parseInt(id);
		Person person = service.getUserById(idPerson);

		ModelAndView model = new ModelAndView("persons/edit", "person", person);
		model.addObject("idPerson", idPerson);
		
		return person != null ?  model : new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.POST)
	public ModelAndView edit(
			@PathVariable(value = "idPerson") String id,
			@ModelAttribute("person") @Valid Person person,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("persons/list");
		}
		
		int idPerson = Integer.parseInt(id);
		service.removeById(idPerson);
		
		person.setId(Person.randInt(10, 9000000));
		service.update(person);
		
		return new ModelAndView("redirect:/persons/list/");
	}
	
	@RequestMapping(value = "/delete/{idPerson}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable(value = "idPerson") String id,
			RedirectAttributes redirectAttributes) {
		
		int idPers = Integer.parseInt(id);
		
		if(!service.exists(idPers)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.person.id", null, null));
			return HOME_REDIRECTION;
		}
		
		for(Person person : service.allPersons())
		{
			if(person.getId().equals(idPers))
				service.remove(person);
		}
		
		return new ModelAndView("redirect:/persons/list/");
	}
}
