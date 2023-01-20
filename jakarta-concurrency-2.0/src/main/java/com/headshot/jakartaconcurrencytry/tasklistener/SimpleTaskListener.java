package com.headshot.jakartaconcurrencytry.tasklistener;

import java.util.concurrent.Future;

import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.concurrent.ManagedTaskListener;
import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;

//@RequestScoped
@ApplicationScoped
public class SimpleTaskListener implements ManagedTaskListener {

	public SimpleTaskListener() {
	}

	@Override
	public void taskSubmitted(Future<?> future, ManagedExecutorService executor, Object task) {
		System.out.println(Thread.currentThread().getName() + " is submitted " + task);
	}

	@Override
	public void taskAborted(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		System.out.println(Thread.currentThread().getName() + " is aborted " + task);
	}

	@Override
	public void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		System.out.println(Thread.currentThread().getName() + " has finished execution " + task);
	}

	@Override
	public void taskStarting(Future<?> future, ManagedExecutorService executor, Object task) {
		System.out.println(Thread.currentThread().getName() + " has started execution " + task);
	}

}
