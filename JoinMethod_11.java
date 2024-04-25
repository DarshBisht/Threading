/*join() method:- If a thread wants to wait for another thread to complete it's task , then
 * 				  we should use join() method for eg:- you are applying for driving licence
 * 				  so there are 3 step procedure step/thread 1 medical thread 2 test drive
 * 				  thread 3 officer approval so in this thread 2 and 3 is waiting for completion
 * 				  of thread 1 and after completion of thread 1 thread 2 will join it and now
 * 				  thread 3 is waiting for thread 2 completion then thread 3 will join in and
 * 				  complete the task.
 * 
 * Methods for join(which is overloaded):-
 *1) public final void join() throws InterruptedException
 *2) public final synchronized void join(long milli) throws InterruptedException
 *2) public final synchronized void join(long milli, int nano) throws InterruptedException
 **/

package com.java.threading;

//join() method program
public class JoinMethod_11 extends Thread {

	// creating Thread class reference to take the reference of main thread
	static Thread mainThread;

	@Override
	public void run() {
		try {
			// Use of join() method
			mainThread.join(); // now child thread will wait for completion of main thread
			for (int i = 1; i <= 5; i++) {
				System.out.println("Child thread " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// Initializing main thread reference to static Thread mainThread variable
		mainThread = Thread.currentThread();

		// class object creation
		JoinMethod_11 t = new JoinMethod_11();
		t.start();

		// Use of join() method
//		t.join();	// now main thread will wait for completion of child thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("Main thread " + i);
			Thread.sleep(1000);
		}
	}
};



//Driving licence program using join() method
class Medical extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Medical starts");
			Thread.sleep(3000);
			System.out.println("Medical completed");
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class TestDrive extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Test drive starts");
			Thread.sleep(5000);
			System.out.println("Test drive completed");
			Thread.sleep(1000);

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class OfficerApproval extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Officer approval pending");
			Thread.sleep(5000);
			System.out.println("Driving licence will be delivered soon");

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class LicenceDemo {
	public static void main(String[] args) throws InterruptedException {
		Medical t1 = new Medical();
		t1.start();
		t1.join();	// main thread is waiting for completion of thread-0
		
		TestDrive t2 = new TestDrive();
		t2.start();
		t2.join();// main thread is waiting for completion of thread-1
		
		OfficerApproval t3 = new OfficerApproval();	//Don not need to create join() method here because it is the last thread which will execute at the end
		t3.start();
	}
};


//Driving licence program without using join() method by another way
class Medical2 extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Medical starts");
			Thread.sleep(3000);
			System.out.println("Medical completed");
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
		
		TestDrive2 t2 = new TestDrive2();
		t2.start();
	}
}

class TestDrive2 extends Thread {
	static Thread testDriveThread=Thread.currentThread();
	
	@Override
	public void run() {
		try {
			System.out.println("Test drive starts");
			Thread.sleep(5000);
			System.out.println("Test drive completed");
			Thread.sleep(1000);

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
		OfficerApproval2 t3 = new OfficerApproval2();
		t3.start();
	}
}

class OfficerApproval2 extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Officer approval pending");
			Thread.sleep(5000);
			System.out.println("Driving licence will be delivered soon");

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class LicenceDemo2 {
	
	public static void main(String[] args) throws InterruptedException {

		Medical2 t1 = new Medical2();
		t1.start();
		
	}
};



//Driving licence program using join() method by another way by using instance reference
class Medical3 extends Thread {
	
	@Override
	public void run() {
		TestDrive3.testDriveThread = Thread.currentThread();
		try {
			System.out.println("Medical starts");
			Thread.sleep(3000);
			System.out.println("Medical completed");
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class TestDrive3 extends Thread {
	static Thread testDriveThread;
	
	@Override
	public void run() {
		OfficerApproval3.officerApprovalThread = Thread.currentThread();
		try {
			testDriveThread.join();
			System.out.println("Test drive starts");
			Thread.sleep(5000);
			System.out.println("Test drive completed");
			Thread.sleep(1000);

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class OfficerApproval3 extends Thread {
	static Thread officerApprovalThread;
	
	@Override
	public void run() {
		try {
			officerApprovalThread.join();
			System.out.println("Officer approval pending");
			Thread.sleep(5000);
			System.out.println("Driving licence will be delivered soon");

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

class LicenceDemo3 {
	
	public static void main(String[] args) throws InterruptedException {

		Medical3 t1 = new Medical3();
		t1.start();
		
		TestDrive3 t2 = new TestDrive3();
		t2.start();
		
		OfficerApproval3 t3 = new OfficerApproval3();
		t3.start();
	}
};


//use of join(long mili) method
class JoinMethod2 extends Thread {

	static Thread mainThread;

	@Override
	public void run() {
		try {
			// Use of join(long milli) method
			mainThread.join(2000); // now child thread will wait for 2 seconds(as given millisecond) till then main thread will execute then it will execute automatically by thread-scheduler 
			for (int i = 1; i <= 5; i++) {
				System.out.println("Child thread " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		mainThread = Thread.currentThread();

		JoinMethod2 t = new JoinMethod2();
		t.start();

		for (int i = 1; i <= 5; i++) {
			System.out.println("Main thread " + i);
			Thread.sleep(1000);
		}
	}
};
