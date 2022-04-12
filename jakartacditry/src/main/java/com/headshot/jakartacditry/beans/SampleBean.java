package com.headshot.jakartacditry.beans;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton @Named
public class SampleBean {

	public String getName() {
		System.out.println("in samplebean");
		return "SampleBean";
	}
}
