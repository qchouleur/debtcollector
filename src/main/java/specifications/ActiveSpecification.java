package specifications;

import models.Plan;
import service.PlanSpecification;

public class ActiveSpecification implements PlanSpecification {

	@Override
	public boolean isSatisfiedBy(Plan plan) {
		return plan.isActive();
	}

}
