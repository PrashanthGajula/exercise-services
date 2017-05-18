package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Activity;

public interface ActivityRepository {

	List<Activity> finaAllActivities();

	Activity finaActivity(String activityId);

}