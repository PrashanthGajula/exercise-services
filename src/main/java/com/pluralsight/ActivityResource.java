package com.pluralsight;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities")//http:local:8080//exercise-services/webapi/activities
public class ActivityResource {
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.finaAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}") //http:local:8080//exercise-services/webapi/activities/1234
	public Activity getActivity(@PathParam ("activityId") String activityId){
		return activityRepository.finaActivity(activityId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user")//http:local:8080//exercise-services/webapi/activities/1234/user
	public User getActivityUser(@PathParam ("activityId") String activityId){
		
		Activity activity = activityRepository.finaActivity(activityId);
		User user = activity.getUser();
		return user;
		//return activityRepository.finaActivity(activityId).getUser();
	}


}
