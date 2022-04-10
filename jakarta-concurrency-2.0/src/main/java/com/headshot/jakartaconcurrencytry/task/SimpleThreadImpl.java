package com.headshot.jakartaconcurrencytry.task;

//import java.util.Map;
//
//import jakarta.enterprise.concurrent.ManagedTask;
//import jakarta.enterprise.concurrent.ManagedTaskListener;

/**
 * 
 * @author headshot
 *
 */
//public class Item implements ManagedTask{
//
////	ManagedTaskListener
//	
//	@Override
//	public ManagedTaskListener getManagedTaskListener() {
//		return null;
//	}
//
//	@Override
//	public Map<String, String> getExecutionProperties() {
//		return null;
//	}
//
//}

public class SimpleThreadImpl implements Runnable
{
	private String ref;
	
	public SimpleThreadImpl(String task) {
		ref = task;
	}
	
	@Override
	public void run() {
		System.out.println("execution started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ref);
		System.out.println("execution finished");
	}	
}