/*Inter-thread communication:- Inter-thread communication is a mechanism in which a
 *a thread releases the lock and enter into paused state and another thread acquires
 *the lock and continue to executed.
 *It is implemented by following methods of Object class:
 *1. wait():- If any thread calls the wait() method, it causes the current thread to
 *			  release the lock and wait until another thread invokes the notify()
 *			  or notifyAll() method for this object, or a specified amount of time
 *			  has elapsed.
 *Syntax : public final void wait() throws InterruptedException (waits until object is notified)
 *		   public final void wait(long timeout) throws InterruptedException (waits for the specified amount of time)
 *
 *2. notify() This method is used to wake up a single thread and releases the object lock
 *Syntax : public final void notify()
 *
 *3. notifyAll() This method is used to wake up all threads that are in waiting state.
 *Syntax : public final void notifyAll()
 *
 *NOTE : To call wait(), notify() or notifyAll() method on any object, thread should
 *		 own the lock of that object i.e. the thread should be inside synchronized area.*/

package com.java.threading;

public class InterThreadCommunication_18 {}	// This class is not for use only for class file naming purpose


//Program without Inter-thread communication
class TotalEearnings extends Thread {
	
	int total=0;
	
	@Override
	public void run () {
		
		for(int i=1; i<=10; i++) {
			total+=100;
		}
	}
}
class MovieBookApp6 {
	
	public static void main(String[] args) {
		
		TotalEearnings te = new TotalEearnings();
		te.start();
		
		System.out.println("Total earning is: "+te.total+" Rs."); // it is printing 0 rupees without executing the thread-0 which is giving wrong result to overcome this issue we will use inter-thread communication.
	}
}

//Program without Inter-thread communication
class TotalEearnings2 extends Thread {
	
	int total=0;
	
	@Override
	public void run () {
		
		//to acquire the lock using synchronized block
		synchronized (this) {
			
			for(int i=1; i<=10; i++) {
				total+=100;
			}
			this.notify();	//it will release the lock of thread-0 and notify the main thread then main thread will acquire the lock. (if you use notifyAll() method it will invoke the all the waiting threads which is inside the synchronized block in the main method)
		}
	}
}
class MovieBookApp7 {
	
	public static void main(String[] args) throws InterruptedException {
		
		TotalEearnings2 te = new TotalEearnings2();
		te.start();
		
		//to sent the main method into waiting state using synchronized block and wait() method
		synchronized(te) {
			//note: it is running without using the notify method in thread-0(it may be due to single program or when thread-0 completes it's task and go to the dead state)
			te.wait();	// it will release the main thread lock and thread-0 will acquire the lock and main thread will wait until it will get invoked by thread-0 (you can use time limits also like 1000 millisecond which is 1 second if thread-0 does not complete it's task under 1 second main thread will automatically will get executed according time provided)
			System.out.println("Total earning is: "+te.total+" Rs.");
		}
//		System.out.println("Total earning is: "+te.total+" Rs.");	// you can write this statement outside the synchronized block also
	}
};