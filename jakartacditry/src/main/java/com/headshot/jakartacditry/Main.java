package com.headshot.jakartacditry;

import com.headshot.jakartacditry.beans.SampleBean2;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

/**
 * 
 * @author nikheel.patel
 *
 */
public class Main {
	
	public static void main(String[] args) {
		try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
	        var myBean = container.select(SampleBean2.class).get();
	        System.out.println(myBean.getName2());
	    }
	}
}