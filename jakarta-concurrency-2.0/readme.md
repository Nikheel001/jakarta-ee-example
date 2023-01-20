* ManagedExecutorService
* ManagedScheduledExecutorService

provides asynchronous capabilities to Jakarta EE application components

task = class which implements Callable or Runnable

* java.util.concurrent.Callable
	* call()
* java.lang.Runnable
	* run()

When a task instance is submitted to a managed instance of an ExecutorService, the task becomes a
contextual task.

contextual invocation points
* jakarta.enterprise.concurrent.ManagedTaskListener
* jakarta.enterprise.concurrent.Trigger

when a task implements ManagedTask </br>
it can specify execution property (TRANSACTION, SUSPEND, ... userdefined ) and ManagedTaskListener 
for ExecutorService to use.

make sure you use proper scopes for application components

todo: task persistance , transaction, triggers