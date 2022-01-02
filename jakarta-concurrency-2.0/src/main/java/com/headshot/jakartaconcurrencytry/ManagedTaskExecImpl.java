package com.headshot.jakartaconcurrencytry;

import com.headshot.jakartaconcurrencytry.task.SimpleThreadImpl;

import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.enterprise.concurrent.ManagedExecutorService;

/**
 * 
 * @author headshot
 *
 */
@Singleton
public class ManagedTaskExecImpl {

	@Resource(name = "java:comp/DefaultManagedExecutorService")
	private ManagedExecutorService mes;

	public void submitTask(SimpleThreadImpl i) {
		mes.submit(i);
	}
}