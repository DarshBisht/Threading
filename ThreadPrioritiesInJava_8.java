/*Thread Priorities:-
 *1) JVM provides the priorities to each thread and according to these priorities JVM
 *	 allocate the processor.
 *2) Priorities are represented in the form of integers value which range from 1 to 10.
 *	 ->1 is MIN_PRIORITY (default integer in java)
 *	 ->5 is NORM_PRIORITY (default integer in java)
 *	 ->10 is MAX_PRIORITY (default integer in java)
 *	 below are not the priorities
 *	 -> 0, <1, >10
 *	 -> MINIMUM_PRIORITY, LOW_PRIORITY, NORMAL_PRIORITY, MIDIUM_PRIORITY, MAXIMUM_PRIORITY, HIGH_PRIORITY
 *3) Method for priorities:-
 *	i) public final void setPriority(int value){};
 *	ii) public final int gerPriority(){};
 *4) By default main thread priority provide by java is 5 which is normal priority, 
 *	 but we can set the priority.
 *5) Default nature:- Priority are inherited from parent thread
 *6) If priority value is not in b/w 1-10, then it will throw run-time exception i.e.
 *	 IllegalArgumentException.
 *7) If multiple thread priority is same so we can not decide which thread will execute
 *	 first and last it is depend on the JVM.
 *8) Priority depends on the platform (Windows does not support priorities).*/

package com.java.threading;

public class ThreadPrioritiesInJava_8 extends Thread {

	@Override
	public void run() {
		System.out.println("Child thread");
		System.out.println("Child thread priority: "+Thread.currentThread().getPriority());	//By default child priority depends on parent priority but we can change the priority
	}

	public static void main(String[] args) {
		
		//Check default priority of main thread
		System.out.println("Main thread default priority: "+Thread.currentThread().getPriority());
		
		//setPriority() method
		Thread.currentThread().setPriority(7);
		System.out.println("Main thread new priority: "+Thread.currentThread().getPriority());
		
		//Use constants priority - (MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY)
		Thread.currentThread().setPriority(MIN_PRIORITY);
		System.out.println("Main thread new2 priority: "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(NORM_PRIORITY);
		System.out.println("Main thread new3 priority: "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(MAX_PRIORITY);
		System.out.println("Main thread new4 priority: "+Thread.currentThread().getPriority());
		
		//Create object of child thread class
		ThreadPrioritiesInJava_8 t = new ThreadPrioritiesInJava_8();
		t.setPriority(MIN_PRIORITY);
		t.start();
	}
};
