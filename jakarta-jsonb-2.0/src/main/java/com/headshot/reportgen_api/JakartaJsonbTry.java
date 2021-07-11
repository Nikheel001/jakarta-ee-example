package com.headshot.reportgen_api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class JakartaJsonbTry {

	public static void main(String[] args) {
		
		User headshot = new User();
		
		headshot.setName("headshot");
		headshot.setAge(23);
		headshot.setOccupation("developer");
		
		// Create custom configuration with formatted output
		JsonbConfig config = new JsonbConfig()
		    .withFormatting(true);

		// Create Jsonb with custom configuration
//		Jsonb jsonb = JsonbBuilder.create(config);
		Jsonb jsonb = JsonbBuilder.create();

		// Use it!
		String result = jsonb.toJson(headshot);
		
		System.out.println(result);
	}
}