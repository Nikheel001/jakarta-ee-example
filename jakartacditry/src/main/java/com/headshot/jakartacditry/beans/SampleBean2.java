package com.headshot.jakartacditry.beans;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton @Named
public class SampleBean2 {

	@Inject
	private SampleBean ref;

	public SampleBean2(SampleBean _ref) {
		ref = _ref;
	}

	public SampleBean2() {
	}

	public SampleBean getRef() {
		return ref;
	}

	public void setRef(SampleBean ref) {
		this.ref = ref;
	}

	public String getName2() {
		System.out.println("in samplebean2");
		return "SampleBean2 " + ref.getName();
	}
}
