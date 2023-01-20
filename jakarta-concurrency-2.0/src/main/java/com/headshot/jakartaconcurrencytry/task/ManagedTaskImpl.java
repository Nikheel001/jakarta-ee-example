package com.headshot.jakartaconcurrencytry.task;

import java.util.Map;

import jakarta.enterprise.concurrent.ManagedTask;
import jakarta.enterprise.concurrent.ManagedTaskListener;

public class ManagedTaskImpl implements ManagedTask, Runnable {

	ManagedTaskListener stl;

	public ManagedTaskImpl(ManagedTaskListener stl) {
		this.stl = stl;
	}

	@Override
	public ManagedTaskListener getManagedTaskListener() {
		return stl;
	}

	@Override
	public Map<String, String> getExecutionProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		System.out.println("===============start==========");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===============hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm==========");
		System.out.println("===============end==========");
	}

}
