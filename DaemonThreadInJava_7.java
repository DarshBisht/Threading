/*Daemon Thread:-
 *1) Definition: Which run in the background of another thread
 *2) use: It provides service to the threads
 *3) Eg:- Garbage collector, Finalizer, Attach listener, Signal dispatcher etc.
 *4) Methods:- a. public final void setDaemon(boolean b)
 *			   b. public final boolean isDaemon()
 *5) Program:-
 *class Test extends Thread
 *{
 *	public void run()
 *	{
 *		System.out.println("Child thread");
 *	}
 *	public static void main(String[] args)
 *	{
 *		System.out.println("Main thread");	// some statement/working should be in current running thread then you can create Daemon thread.
 *		Test t = new Test();
 *		t.setDaemon(true);	// setDaemon() method can be used after object creation of target thread class and before start() method.
 *		t.start();
 *	}
 *};
 *6) Life:- It's life depends on another thread (Because it run as a back-end thread for another thread)
 *7) Daemon nature:- It inherit the nature/properties from it's parent thread (from were Daemon thread is created).
 *8) JVM role in Daemon thread:- JVM does not depend on Daemon thread because Daemon thread is
 *	 depended to another thread JVM runs until the normal thread are at running state if
 *	 every thread at dead state and Daemon thread is executing JVM automatically kill that 
 *	 thread and then JVM will get shutdown.
 *9) Daemon priority:- Most of times, Daemon thread has low priority. But we can change
 *					   it's priority according our needs.
 *
 *Cases to be noted:-
 *Case 1: We have to create the Daemon thread before starting the thread if we create Daemon
 *		  thread after starting it, it will throw run-time exception i.e. IllegalThreadStateException.
 *Case 2: We cannot create main thread as Daemon thread. Sop(Thread.currentThread().setDaemon(true));
 *		  it will throw the run-time exception i.e. IllegalThreadStateException.
 *Case 3: If a parent thread is Daemon thread so it's child thread will be also a Daemon thread
 *		  by default you do not to create that child thread as Daemon thread.
 *
 *
 * 
 * */

package com.java.threading;

//Daemon thread program
public class DaemonThreadInJava_7  extends Thread{
	
	@Override
	public void run() {	// this thread will run the background of the main thread or from where it called.
		
		//isDaemon() method
		if(Thread.currentThread().isDaemon()) {
			System.out.println("Daemon thread");	//When JVM found main thread at dead state JVM kill the Daemon thread.
		}
		else {
			System.out.println("Child thread");
		}
	}

	public static void main(String[] args) {
		
		//Check main thread is Daemon
		System.out.println("Is main thead is Daemon thread: "+Thread.currentThread().isDaemon());
	
		System.out.println("Main thread");
		DaemonThreadInJava_7 t = new DaemonThreadInJava_7();
		
		//setDaemon(boolean b) method
		t.setDaemon(true);
		t.start();
		System.out.println("Still main thread is in running state");
	}
};