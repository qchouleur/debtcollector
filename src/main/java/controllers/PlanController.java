package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

import models.Identifier;
import models.Participation;
import models.Person;
import models.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
@RequestMapping(value = {"/", "/index"})
public class PlanController {

	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	public MessageSource messageSource;
	private PlanService service = StaticDataStorage.service();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		model.addAttribute("plans", service.all());
		
		return "index";

	}
	
	@RequestMapping(value = "plan/create", method = RequestMethod.GET)
	public ModelAndView create(ModelMap model) {
		return new ModelAndView("plans/create", "plan", new Plan());
	}
	
	@RequestMapping(value = "plan/create", method = RequestMethod.POST)
	public ModelAndView create(
			@ModelAttribute("plan") @Valid Plan plan,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("redirect:/");
		}
		
		plan.setId(Identifier.generate());
		service.update(plan);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "plan/edit/{idPlan}", method = RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable(value = "idPlan") String id) {
		
		Identifier idPlan = Identifier.fromString(id);
		Plan plan = service.getById(idPlan);

		ModelAndView model = new ModelAndView("plans/edit", "plan", plan);
		model.addObject("idPlan", idPlan);
		
		return plan != null ?  model : new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "plan/edit/{idPlan}", method = RequestMethod.POST)
	public ModelAndView edit(
			@PathVariable(value = "idPlan") String id,
			@ModelAttribute("plan") @Valid Plan plan,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("redirect:/");
		}
		
		Identifier idPlan = Identifier.fromString(id);
		List<Participation> tmpParticipation = service.getById(idPlan).getParticipations();
		service.remove(idPlan);
		
		plan.setId(Identifier.generate());
		plan.setParticipations(tmpParticipation);
		service.update(plan);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "plan/delete/{idPlan}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable(value = "idPlan") String id,
			RedirectAttributes redirectAttributes) {
		
		Identifier idPlan = Identifier.fromString(id); 
				
		if(!service.exists(idPlan)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.plan.id", null, null));
			return HOME_REDIRECTION;
		}
		
		service.remove(idPlan);
		
		return new ModelAndView("redirect:/");
	}
}

