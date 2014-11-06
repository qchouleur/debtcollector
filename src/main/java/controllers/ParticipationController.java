package controllers;

import java.util.List;

import javax.validation.Valid;

import models.Identifier;
import models.Participation;
import models.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.PlanService;
import data.StaticDataStorage;

@Controller
@RequestMapping("/participations")
public class ParticipationController {

	
	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	public MessageSource messageSource;
	public StaticDataStorage data = new StaticDataStorage();
	public List<Plan> plans = data.getPlans();
	private PlanService service = StaticDataStorage.service();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
	@RequestMapping(value = "/create/{idPlan}", method = RequestMethod.GET)
	public ModelAndView create(ModelMap model,
			@PathVariable(value = "idPlan") String id) {
		
		Identifier idPlan = Identifier.fromString(id);
		
		ModelAndView modelView = new ModelAndView("participations/create", "participation", new Participation());
		modelView.addObject("users", service.allPersons());
		modelView.addObject("idPlan", idPlan);
		return modelView;
	}
	
	@RequestMapping(value = "/create/{idPlan}", method = RequestMethod.POST)
	public ModelAndView create(
			@PathVariable(value = "idPlan") String id,
			@Valid Participation participation,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("redirect:/");
		}
		
		Identifier idPlan = Identifier.fromString(id);
		Plan plan = service.getById(idPlan);
		
		plan.addParticipation(participation);
		
		return new ModelAndView("redirect:/");
	}
	
}
