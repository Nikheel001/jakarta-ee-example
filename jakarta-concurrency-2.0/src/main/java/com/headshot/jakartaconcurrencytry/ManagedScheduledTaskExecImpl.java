package com.headshot.jakartaconcurrencytry;

import java.util.concurrent.TimeUnit;

import com.headshot.jakartaconcurrencytry.task.SimpleThreadImpl;

import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;

/**
 * 
 * @author headshot
 *
 */
@Singleton
public class ManagedScheduledTaskExecImpl {

	@Resource(name = "java:comp/env/concurrent")
	private ManagedScheduledExecutorService mses;
	
	public void scheduleSubmit(SimpleThreadImpl s) {
		mses.scheduleAtFixedRate(s, 0, 5000, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * <managedScheduledExecutorService jndiName="concurrent/scheduledExecutor1">
	<contextService>
		<classloaderContext/>
	</contextService>
       <concurrencyPolicy max="5"/>
</managedScheduledExecutorService>
	 */
}
