package com.headshot.hsqldbsourcebatchtry.resource;

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
@Path("hsqldbsource")
public class HsqlDbSourceBatchResource {

	@Path("/")
	@GET
	public Response spawnJob() {
		var jobOperator = BatchRuntime.getJobOperator();
		if (jobOperator != null) {
			var execID = jobOperator.start("hsqldbchunk", null);
			return Response.ok(String.format("started job jobId -> {%d}", execID)).build();
		}
		return Response.ok("not started").build();
	}
}
