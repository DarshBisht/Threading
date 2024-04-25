/*Thread Interrupt:- 
 *1) Use:- It is used to interrupt an executing thread
 *2) Interrupt():- This method will only works when the thread is in sleeping or waiting
 *	 state (sleep() or wait())	(wait() method is of Object class method)
 *3) If thread is not in sleeping or waiting state the calling an interrupt() method
 *	 will perform normal behavior.
 *4) when we use an interrupt() method it throws an exception of InterruptedException.
 *5) Syntax:-
 *	 public void interrupt(){};
 *
 *
 *Difference between interrupted() and isInterrupted() method:-
 *1) interrupted() method is used to check weather a thread is interrupted or not.
 *	 And isInterrupted() method is used to check weather a thread is interrupted or not (same similarity not difference).
 *2) interrupted() method clears the interrupted status from true to false if thread is interrupted.
 *	 And isInterrupted() method does not clear the interrupted status.
 *3) interrupted() method will change the result if called twice.
 *	 but isInterrupted() method will produce same result if called twice.
 *4) Syntax of interrupted():- public static boolean interrupted(){};
 *	 Syntax of isInterrupted():- public boolean isInterrupted(){};
 **/

package com.java.threading;

//use of interrupt() method
public class ThreadInterruptMethodsInJava_13 extends Thread {

	@Override
	public void  run() {
		try {
			for(int i=1; i<=5; i++) {
				System.out.println(i);
				Thread.sleep(1000);	//sleep method will be interrupted if you do not use sleep() method then no effect will be of interrupt method
			}
		} catch(Exception e) {
			System.out.println(Thread.currentThread().getName()+" is interrupted :- "+e);
		}
			
	}
	public static void main(String[] args) throws InterruptedException {
		
		ThreadInterruptMethodsInJava_13 t = new ThreadInterruptMethodsInJava_13();
		t.start();
//		t.join();	//if you use join() then no effect will be of interrupt() method
		t.interrupt();	//when sleep will work on sleep() or wait() method only
		
	}
};



//Use of interrupted() and isInterrupted() method
class TestInterrpedAndIsInterrupted extends Thread {
	
	@Override
	public void  run() {
		
		//interrupted() method (You can call this method by Thread class directly because it is a static method)
		System.out.println("A1 interrupted method: "+Thread.interrupted());	//true->false It's convert the value/result from true to false if interrupted when interrupt() method is called (helps in to stop the interrupt() method effect) 
		System.out.println("A2 interrupted method: "+Thread.interrupted());	//false->false
		
		//isInterrupted() method (You can not call this method by Thread class directly because it is not static method to use this method use currentThread() method because it's return type is Thread)
		System.out.println("B1 isInterrupted method: "+Thread.currentThread().isInterrupted());	// true->true It does not convert the value it keeps same
		System.out.println("B2 isInterrupted method: "+Thread.currentThread().isInterrupted());
		
		try {
			for(int i=1; i<=5; i++) {
				System.out.println(i);
				Thread.sleep(1000);
				System.out.println(Thread.interrupted());	//To check the status of interrupted() method
			}
		} catch(Exception e) {
			System.out.println(Thread.currentThread().getName()+" is interrupted :- "+e);
		}
			
	}
	public static void main(String[] args) throws InterruptedException {
		
		TestInterrpedAndIsInterrupted t = new TestInterrpedAndIsInterrupted();
		t.start();
		t.interrupt();	//You can check the effect of the methods by commenting this method.
		
	}
};