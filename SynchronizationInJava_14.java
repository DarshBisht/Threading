/*Synchronization:-
 *1. What is Synchronization?
 *	 It is a process by which we control the accessability of multiple threads to a 
 *	 particular shared resource.
 *2. Problem which can occur without Synchronization:-
 *	 1) Data inconsistancy
 *	 2) Thread interference
 *3. Advantages of Synchronization:-
 *	 1) No data inconsistancy
 *	 2) No thread interference
 *4. Disadvantages of Synchronization:-
 *	 1) Increases the waiting time period of threads
 *	 2) Create performance problems
 *	 To overcome synchronization disadvantages, java provides one package i.e. java.util.concurrent
 *
 *How to achieve Synchronization?
 *   Types of Synchronization:-
 *1. Process Synchronization (Not present in java multi-threading)
 *2. Thread Synchronization (2 types of thread synchronization)
 *	 1) Mutual Exclusive: Can be achieved by 3 ways:-
 *		i) By "Synchronized Method"
 *		ii) By "Synchronized Block"
 *		iii) By "Static Synchronized"
 *	 2) Cooperation (Inter-thread communication in java): Can be achieved by following
 *		methods of Object class:-
 *		i) wait()
 *		ii) notify()
 *		iii) notifyAll()
 **/

package com.java.threading;

public class SynchronizationInJava_14 {}	// This class is not for use only for class file naming purpose


//Program to see the effect without synchronization(when you do not use synchronization in multi-threading so it may impact the output result if the multiple thread call the same/single resource symultaniousally)
class BooKTheaterSeat {	
	int total_seats = 10;

	void bookSeats(int seats) {	//this is an resource for threads
		if (total_seats >= seats) {
			System.out.println(seats + " Seats booked successfully");
			total_seats -= seats;
			System.out.println("Seats left: " + total_seats);
		} else {
			System.out.println("Sorry seats can not be booked..!!");
			System.out.println("Seats left: " + total_seats);
		}
	}
}

class MovieBookApp extends Thread {

	//Using object reference(if you create full object here so multiple object creation can be happen depends on the threads like 2 threads are there so 2 object will be created with same name) and using static keyword because main method is static where object is created.
	static BooKTheaterSeat book;
	int seat;

	@Override
	public void run() {
		//using/accessing resource method
		book.bookSeats(seat);
	}

	public static void main(String[] args) {

		//Creating object
		book = new BooKTheaterSeat();

		MovieBookApp Darsh = new MovieBookApp();
		Darsh.seat = 7;
		Darsh.start();

		MovieBookApp Raj = new MovieBookApp();
		Raj.seat = 6;
		Raj.start();

	}
};