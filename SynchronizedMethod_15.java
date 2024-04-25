/*synchronized method:-
 *In java every object has it's one unique lock and in java there are two areas for objects:-
 *1) non-synchronized area (when you do not use the synchronized method thorough object 
 *							it goes to the non-synchronized area which is not thread safe)
 *2) synchronized area (when you use the synchronized method through object it goes  
 *						to the synchronized area which is thread safe and it create 
 *						the object locking which means at a time one thread will
 *						use the resources and other threads will be on waiting state)
 **/

package com.java.threading;

public class SynchronizedMethod_15 {}	// This class is not for use only for class file naming purpose


//Program to see the effect of synchronization(when you do not use synchronization in multi-threading so it may impact the output result if the multiple thread call the same/single resource symultaniousally)
class BooKTheaterSeat2 {	
	int total_seats = 10;

	//Synchronized method
	synchronized void bookSeats(int seats) {	//this is an resource for threads
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

class MovieBookApp2 extends Thread {

	static BooKTheaterSeat2 book;
	int seat;

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seat);
	}

	public static void main(String[] args) {

		book = new BooKTheaterSeat2();
		
		MovieBookApp2 Darsh = new MovieBookApp2();
		Darsh.seat = 7;
		Darsh.start();

		MovieBookApp2 Raj = new MovieBookApp2();
		Raj.seat = 6;
		Raj.start();

	}
};