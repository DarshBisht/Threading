/*yield() method:- which stops the current executing thread & give a chance to other threads
 *				   for execution for eg. you are at billing counter and you have to purchase
 *				   a chocolate only it will take few minutes for billing but you are at second
 *				   position so your ahead person has purchased lot of thing so it will take
 *				   more minutes for billing so what yeild() method will do it will stop the
 *				   current thread and and execute the another threads.
 *
 *Working:- Java 5- internally it uses sleep() method
 *			Java 6- Thread provides the hint to the thread-scheduler, then it depends on
 *					thread-scheduler to accept or ignore the hint (and it depends on the priority if other thread priority is higher then current thread (where yield() method is used ) then it give chance to the another threads or it may get ignore also by thread-scheduler).
 *
 *Method:- public static native void yield();*/
package com.java.threading;

//yield() method program
public class YieldMethod_10 extends Thread {

	@Override
	public void run() {

		Thread.yield();	//It give hint to the thread-scheduler then it stop the current thread execution or it may get ignore also by thread-scheduler and may be it depends on platform
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
	}

	public static void main(String[] args) {
		YieldMethod_10 t = new YieldMethod_10();
		t.start();
//		Thread.yield();	//If you want main method/thread to stop and provide chance to other threads for execution. 
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
	}
};