package com.headshot.jakartaconcurrencytry;

import com.headshot.jakartaconcurrencytry.task.SimpleThreadImpl;

import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;

/**
 * 
 * @author headshot
 *
 */

@ApplicationPath("")
@Path("")
public class SimpleRestController extends Application {

	@Inject
	private ManagedTaskExecImpl mtei;

	@Inject
	private ManagedScheduledTaskExecImpl mstei;

	@Path("/start")
	@GET
	public String spawnTask() {
		mtei.submitTask(new SimpleThreadImpl("once"));
		return "ok";
	}

	@Path("/schedule")
	@GET
	public String spawnScheduledTask() {
		mstei.scheduleSubmit(new SimpleThreadImpl("welcome headshot"));
		return "done";
	}
}
