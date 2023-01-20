package com.headshot.jakartaconcurrencytry;

import com.headshot.jakartaconcurrencytry.task.ManagedTaskImpl;
import com.headshot.jakartaconcurrencytry.task.SimpleThreadImpl;
import com.headshot.jakartaconcurrencytry.tasklistener.SimpleTaskListener;

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

	@Inject
	SimpleTaskListener stl;

	@Path("/start")
	@GET
	public String spawnTask() {
		mtei.submitTask(new SimpleThreadImpl("once"));
		return "ok";
	}

	@Path("/start2")
	@GET
	public String spawnTask2() {
		mtei.submitTask(new ManagedTaskImpl(stl));
		return "ok";
	}

	@Path("/schedule")
	@GET
	public String spawnScheduledTask() {
		mstei.scheduleSubmit(new SimpleThreadImpl("welcome headshot"));
		return "done";
	}
}
