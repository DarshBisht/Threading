/*Thread class sleep() methods:-
 * class Thread
 * {
 * 	1)public static native void sleep(long milli) throws InterruptedException	// native method and it throws compile time exception overloaded method
 * 	2)public static void sleep(long milli, int nano) throws InterruptedException	
 * }
 * 
 * sleep():- The sleep() method is used to dely the program with milliseconds or nanoseconds
 *
 *Uses:- Like in blinking bulbs, timer etc.
 *
 *sleep() method important points:-
 *1. If the value of milliseconds is negative then "illegalArgumentException" is thrown.
 *2. If the value of nanoseconds is not in the range 0-999999 then "illegalArgumentException" is thrown.
 *3. Whenever we want to use the sleep() method we also need to handle the "InterruptedException". if
 *	 we will not handle it, the JVM will show a compilation error.
 *4. When any thread is sleeping and if any other thread interrupts it, then it throws "InterruptedException".
 *5. The sleep() method always pauses the current thread execution. When the JVM finds the sleep()
 *	 method in code, it checks that which thread is running and pause the execution of thread.
 *6. When we use sleep() method to pause the execution of thread. the thread scheduler assigns the
 *	 CPU to another thread if any thread exists. So, there is no guarantee that the thread wakes
 *	 up exactly after the time specified in sleep() method. It totally depends on the thread scheduler.
 *7. While the thread is sleeping, it doesn't lose any locks or monitors that it had acquired before sleeping.
 **/
package com.java.threading;

public class SleepMethod_9 {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			// sleep()
			Thread.sleep(1000); // It will pause the execution for 1 second in every iteration
//			Thread.sleep(0, 999999);// 1 second = 1,00,00,00,000 nanoseconds
		}
	}
};

//use of sleep() method
class TestSleep extends Thread {

	@Override
	public void run() { // you are not allowed to throws exception in run() thread method

		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(700);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		TestSleep t = new TestSleep();
		t.start();
		for (int i = 6; i <= 10; i++) {
			Thread.sleep(3000);
			System.out.println(i);
		}
	}
};

//Timer program
class Timer {

	public static void main(String[] args) throws InterruptedException {

		int a = 0, b = 0, c = 0;
		// For hours
		System.out.println(a + ":" + b + ":" + c);
		for (int i = 0; i < 24; i++) {
			a = i;
			// for minutes
			for (int j = 0; j < 60; j++) {
				b = j;
				// for seconds
				for (int k = 1; k <= 60; k++) {
					c = k;
					Thread.sleep(1000);
					System.out.println(a + ":" + b + ":" + c);
				}
			}
		}
	}
};


//use of sleep() method multi-threading
class TestSleepMultipleThread extends Thread {

	@Override
	public void run() {

		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(700);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		TestSleepMultipleThread t1 = new TestSleepMultipleThread();
		t1.start();	// Thread-0
		TestSleepMultipleThread t2 = new TestSleepMultipleThread();
		t2.start();	// Thread-1
	}
};