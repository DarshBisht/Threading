/*When to use Thread class and Runnable interface:-
 *Thread(class):- In normal classes we can extends thread class to make that class thread
 *		   but if the class is already extending some another class so there you
 *	       can not extends Thread class because we could not use multiple inheritance
 *		   in java.
 *Runnable(interface):-we can implements Runnable class in the case when a class already
 *					   extending some class but we want to make that class as a thread
 *					   so by implementing the Runnable interface we can make that class
 *					   as a thread (In interface we can use multiple inheritance) 
 *					   in real-world we have to use Runnable interface to create thread
 *					   (Real-time project use Runnable interface)*/
package com.java.threading;

public class CreateThreadUsingThreadClassAndRunableInterface_4 {}	//This class is not for use only for class file naming purpose.

//Step to create thread by extending Thread class
class TestThread extends Thread {	//1st step

	@Override
	public void run() {	//2nd step
		for(int i=0; i<=5; i++ )
		System.out.println("I'm in TestThread class");
	}
	
	public static void main(String[] args) {

		TestThread t = new TestThread();	//3rd step
		t.start();	//4th step 
//		t.start();	//It will throw the RuntimeException (IllegalThreadStateException) because we can not alive the thread which is in dead state.
		
		for(int i=0; i<=5; i++ )
			System.out.println("I'm in main method 1");
	}
};


//Step to create thread by implementing Runnable
class TestThread2 implements Runnable {	//1st step

	@Override
	public void run() {	//2nd step
		System.out.println("I'm in TestThread2 class");
	}
	public static void main(String[] args) {

		TestThread2 t2 = new TestThread2();	//3rd step
		Thread t = new Thread(t2);	//4th step	passing the t2 reference variable in thread class constructor (Initializing the constructor)
		t.start();	//5th step 
		
		for(int i=0; i<=5; i++ )
			System.out.println("I'm in main mehtod 2");
	}
};


//Create thread by extending thread class and implementing Runnable interface
class TestThread3 extends Thread implements Runnable {	//1st step

	@Override
	public void run() {	//2nd step
		System.out.println("I'm in TestThread3 class");
	}
	public static void main(String[] args) {

		TestThread3 t3 = new TestThread3();	//3rd step
		t3.start();	//4th step 
		
		Thread t = new Thread(t3);	//we can user this approach to call the start method by implementing the Runnable interface
		t.start();
		System.out.println("I'm in main mehtod 3");
	}
};


//run() method overloading by extending Thread class
class TestThread4 extends Thread {

	@Override
	public void run() {	//This is a thread
		for(int i=0; i<=5; i++ )
		System.out.println("I'm in TestThread4 class");
	}
	
	//Method overloading
	public void run(String s) {	//this is normal overloaded run() method
		start();	// calling start method (Parent class run method/thread will be called)
		for(int i=0; i<=5; i++ )
		System.out.println(s+" i'm in TestThread4 class method overloaded");
	}
	public static void main(String[] args) {

//		TestThread4 t4 = new TestThread4();
//		t4.start(); 
		TestThread4 tt = new TestThread4();
		tt.run("Hey");	// we can override the method but it will not be thread more it will be just normal method only
		
	}
};