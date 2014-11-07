package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import models.Identifier;
import models.Participation;
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
@RequestMapping("/participations")
public class ParticipationController {

	
	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");
	
	@Autowired
	public MessageSource messageSource;
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
			@ModelAttribute("person") String person,
			@ModelAttribute("amount") String amount,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("redirect:/");
		}
		
		Person personToParticipate = service.getUserById(Integer.parseInt(person));
		Participation participation = new  Participation(personToParticipate,Double.parseDouble(amount));
		
		Identifier idPlan = Identifier.fromString(id);
		Plan plan = service.getById(idPlan);
		
		plan.addParticipation(participation);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/list/{idPlan}", method = RequestMethod.GET)
	public ModelAndView list(ModelMap model,
			@PathVariable(value = "idPlan") String id) {
		
		Identifier idPlan = Identifier.fromString(id);
		Plan plan = service.getById(idPlan);
		
		ArrayList<String> detail = detailCalcul(plan.getParticipations(), plan.getAmount());
		
		ModelAndView modelView = new ModelAndView("participations/list");
		modelView.addObject("participations", detail);
		return modelView;
	}

	private ArrayList<String> detailCalcul(List<Participation> participations, double amount) {
		
		ArrayList<String> detail = new ArrayList<String>();
		
		for(Participation participation : participations)
		{
			if(participation.getAmount() < amount/participations.size())
			{
				detail.add(participation.getPerson().getFirstName() + " " +
						participation.getPerson().getLastName() + " " + " doit " +
						(amount/participations.size()-participation.getAmount()) + " euros");
			}
		}
		
		return detail;
	}
	
}
