/*Thread class Constructors:-
 *Normal constructors:
 *1) Thread() :- default constructor
 *2) Thread(Runnable target):- parameterized constructor (It is used when we implement Runnable interface  and create the object of target class which is implementing Runnable class by passing the reference of that class object to run the thread)
 *3) Thread(String name):-	parameterized constructor (It is used to provide the thread name)
 *4) Thread(Runnable target, String name):- (It is used while implementing the Runnable and you want to create the object by passing the reference variable and also want to name the thread)
 *
 *Thread group related constructors:
 *5) Thread(ThreadGroup tg, Runnable target):- It is related to thread group (provide group to the thread) and below 3 cons. also
 *6) Thread(ThreadGroup tg, String name):-	here we can pass thread group with thread name
 *7) Thread(ThreadGroup tg, Runnable target, String name):-	here we can pass thread group, reference name with thread name
 *8) Thread(ThreadGroup tg, Runnable target, String name, long stackSize):- here we can also find stack size
 * 
 *Thread class Methods:- there are many methods in Thread class but there are some main methods showing below
 *Basic methods:
 *1) run():- this method is used to provide the task inside run() method
 *2) start():-this method is used to start the thread and execute the run() method	(synchronized method)
 *3) currentThread():- It's a static method this method is used to provide the reference of the thread (native method- which is written in different language it's implementation is not done in java we are just accessing it)
 *4) isAlive():- this method is used to check is thread alive or not (to check the thread is it in dead stage or not) it return the boolean value. (native method)
 *
 *Naming related methods:
 *5) getName():- this method is used to get the thread name.
 *6) setName(String name):- this method is used to set/provide the thread name. (synchronized method)
 
 *Daemon thread related methods:
 *7) isDaemon():- It returns the value in the form of boolean
 *8) setDaemon(boolean b):- In this if we provide true it will be Daemon thread not.
 *
 *Priority based related methods:
 *9)getPriority():-
 *10)setPriority(int pv):- 
 *
 *Preventing thread execution related methods (these method help to stop the execution of threads):
 *11) sleep():- In the sleep we provide the time sleep("time will come here"). (native method)
 *12) yield():- (native method)
 *13) join() :-
 *14) suspend():- this is method deprecated now(No longer in use now in java)
 *15) resume():- this is method deprecated now(No longer in use now in java)
 *16) stop():- this is method deprecated now(No longer in use now in java)
 *17) destroy():- this is method deprecated now(No longer in use now in java)
 *
 *Thread Interruption related methods:
 *18)interrupt():-
 *19)isInterrupted():-
 *20)interrupted():-
 *
 *Inter-thread communication: (these method do not come under the thread class it comes under the Object class)
 *class Object
 *{
 *	//wait();
 *	//notify();
 *	//notifyAll();
 *}
 **/

package com.java.threading;

public class ThreadClassMethodsAndConstructors_6 {}	//This class is not for use only for class file naming purpose

//Thread class constructor- Thread(Runnable target, String name;);
class TestThreadCons implements Runnable {

	@Override
	public void run() {
		System.out.println("Test Thread Constructor");
	}
	public static void main(String[] args) {
		TestThreadCons t = new TestThreadCons();
		Thread th = new Thread(t,"deepak");	//Thread(Runnable target, String name)
		System.out.println("TestThreadCons class thread name is: "+th.getName());	// It will print thread name deepak
		th.start();
	}
};


//Thread class methods- currentThread(), isAlive(), getName(), setName()
class TestThreadMethods {
	
	//Testing thread main method
	public static void main(String[] args) {
		//Get current running thread name
		System.out.println(Thread.currentThread().getName());	//It will print the current running thread name which is main because main is already a thread created by JVM.
		//We can change the main thread name
		Thread.currentThread().setName("darshan");	//changing the main thread name by darshan
		System.out.println("New thread name: "+Thread.currentThread().getName());	//Now it will print thread name darshan
//		System.out.println(10/0);	//Now it will print Exception in thread "darshan" because i have changed the thread name.
	}
}
//User defined method
class TestThreadMethods2 extends Thread{
	
	@Override
	public void run() {	//thread-0 JVM provide this name by default to the user defined threads
		System.out.println("Thread task is executed by: "+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		
		//currentThread(), getName() Get current running thread name
		System.out.println("Hello is printed by: "+Thread.currentThread().getName());
		
		//Create object of user defined class 
		TestThreadMethods2 t1 = new TestThreadMethods2();
		t1.start();	//thread-0
		TestThreadMethods2 t2 = new TestThreadMethods2();
		t2.start();	//thread-1
		TestThreadMethods2 t3 = new TestThreadMethods2();
		
		//setName() set thread name
		t3.setName("thread-darshan");
		t3.start();	//thread-darshan
		
		//isAlive()	If thread will be in executing state it will print true if it will be in dead state then it will print false.
		System.out.println("Is main thead is alive: "+Thread.currentThread().isAlive());
		System.out.println("Is thread-1 is alive: "+t2.currentThread().isAlive());
	}
};