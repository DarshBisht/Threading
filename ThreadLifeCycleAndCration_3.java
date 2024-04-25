/*Two ways to create threads:-
 *1) Thread (class)(package: java.lang;)
 *class Thread
 *{
 *	//constructor
 *	//methods:-
 *		run()
 *		start()
 *		sleep()
 *		join()
 *		getName() & setName()
 *		interrupted() ,priority()
 *	//there are more methods also in Thread class
 *}
 *2) Runnable(interface) (package: java.lang;)
 *interface Runnable	//this is a functional interface
 *{
 *	//public abstract void run();
 *}
 *
 *
 *Life cycle of the thread:- (5 stages)
 *i) create/new thread/born ii) runnable(JVM will allocate the processor) 
 *iii) running iV) wait/hold(non-runnalble state) v) dead(when task is completed)*/

package com.java.threading;

public class ThreadLifeCycleAndCration_3 {}	//This class is not for use only for class file naming purpose.


//Creation of thread class
class Test1Thread extends Thread {	//First step: Extends the Thread class
	
	@Override
	public void run() {	//Second step: Override the run() method
		//Task of the threads will come inside the run() method
		System.out.println("I'm in Test1Thread class");
	}
	public static void main(String[] args) {
		Test1Thread t = new Test1Thread();	//Third step: Created an object of the class
		t.start();	//Fourth step: Start the thread by using start() method
	}
}
