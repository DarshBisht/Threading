/*Synchronized Block:- It is used to reduce the waiting time for the threads by using
 * 					   synchronized block where necessary resource(particular code) 
 * 					   can be executed by the threads which saves the waiting time of 
 * 					   the threads and it also acquire the lock when we use synchronized block
 * 
 *Syntax:-
 *synchronized("object reference expression")
 *{
 *	//sensitive code part (thread safe code)
 *};
 *
 *scope:- synchronized block scope is lower the synchronized method
 *
 *working:- same working as synchronized method.(Acquire the lock for synchronized area)*/

package com.java.threading;

public class SynchronizedBlock_16 {}	// This class is not for use only for class file naming purpose


//use and effect of synchronized block using multi-threading
class BooKTheaterSeat3 {	
	int total_seats = 10;

	void bookSeats(int seats) {	//this is an resource for threads
		
		//below print method for see the flow of threads using synchronized block
		System.out.println("Before synchro block: "+Thread.currentThread().getName());
		System.out.println("Before synchro block: "+Thread.currentThread().getName());
		System.out.println("Before synchro block: "+Thread.currentThread().getName());
		System.out.println("Before synchro block: "+Thread.currentThread().getName());
		
		//Synchronized block
		synchronized (this) {//here this keyword for representing the current object reference(book) // using this synchronized block it will save the time for thread if there are thousands of code written inside the block it not necessary to use the synchronized block it will acquire the lock for whole method so it is better to use the synchronized block for particular block where thread get interference and Data inconsistancy
			if (total_seats >= seats) {
				System.out.println(seats + " Seats booked successfully");
				total_seats -= seats;
				System.out.println("Seats left: " + total_seats);
			} else {
				System.out.println("Sorry seats can not be booked..!!");
				System.out.println("Seats left: " + total_seats);
			}
		}
		System.out.println("After synchro block: "+Thread.currentThread().getName());
		System.out.println("After synchro block: "+Thread.currentThread().getName());
		System.out.println("After synchro block: "+Thread.currentThread().getName());
		System.out.println("After synchro block: "+Thread.currentThread().getName());
	}
}

class MovieBookApp3 extends Thread {

	static BooKTheaterSeat3 book;
	int seat;

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seat);
	}

	public static void main(String[] args) {

		book = new BooKTheaterSeat3();
		
		MovieBookApp3 Darsh = new MovieBookApp3();
		Darsh.seat = 7;
		Darsh.start();

		MovieBookApp3 Raj = new MovieBookApp3();
		Raj.seat = 6;
		Raj.start();

	}
};