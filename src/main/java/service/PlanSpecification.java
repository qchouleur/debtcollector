package service;

import models.Plan;

public interface PlanSpecification {

	boolean isSatisfiedBy(Plan plan);

}
