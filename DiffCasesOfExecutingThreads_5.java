/*There are 4 cases to create threads:-
 *1) Performing single task from single thread.
 *2) Performing single task from multiple thread.
 *3) Performing multiple task from single thread.(this is not possible in thread)
 *4) Performing multiple task from multiple thread.
 *
 **/

package com.java.threading;

public class DiffCasesOfExecutingThreads_5 {}	//This class is not for use only for class file naming purpose


//Case 1: Single task single thread
class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 1");
	}
}
class Test1Thread1 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
	}
};


//Case 2: Single task multiple thread
class Thread2 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 2");
	}
}
class Test1Thread2 {
	public static void main(String[] args) {
		Thread2 t1 = new Thread2();
		t1.start();
		Thread2 t2 = new Thread2();
		t2.start();
	}
};


//Case 3: Multiple task Single thread (Not possible by single thread we can perform only single task)
class Thread3 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 3");
	}
}
class Thread4 extends Thread {	//Could not achieve second task by single thread(At a time only one task can be achieve by single thread)

	@Override
	public void run() {
		System.out.println("Thread 4");
	}
}
class Test1Thread3AndThread4 {
	public static void main(String[] args) {
		Thread3 t1 = new Thread3();
		t1.start();	//At a time you can perform single task by single thread to perform the second task you will have to create second thread also by using start() method.
	}
};


//Case 4: Multiple task multiple thread
class Thread5 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 5");
	}
}
class Thread6 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 6");
	}
}
class Test1Thread5AndThread6 {
	public static void main(String[] args) {
		Thread5 t1 = new Thread5();
		t1.start();
		Thread6 t2 = new Thread6();
		t2.start();
	}
};