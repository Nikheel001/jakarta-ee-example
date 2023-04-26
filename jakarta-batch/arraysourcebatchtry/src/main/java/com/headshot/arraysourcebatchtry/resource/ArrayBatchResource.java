package com.headshot.arraysourcebatchtry.resource;

import jakarta.batch.runtime.BatchRuntime;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author nikheel.patel
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("arr")
public class ArrayBatchResource {

	@Path("/")
	@GET
	public Response listAll() {
		var jobOperator = BatchRuntime.getJobOperator();
		System.out.println(jobOperator == null);
		if (jobOperator != null) {
			var execID = jobOperator.start("arraychunk", null);
			System.out.println(execID);
			return Response.ok("started").build();
		}
		return Response.ok("not started").build();
	}
}
