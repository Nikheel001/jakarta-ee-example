package com.headshot.filesourcebatchtry.resource;

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
@Path("filesource")
public class FileSourceBatchResource {

	@Path("/")
	@GET
	public Response spawnJob() {
		var jobOperator = BatchRuntime.getJobOperator();
		System.out.println(jobOperator == null);
		if (jobOperator != null) {
			var execID = jobOperator.start("filechunk", null);
			System.out.println(execID);
			return Response.ok("started").build();
		}
		return Response.ok("not started").build();
	}
}
