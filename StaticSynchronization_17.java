/*Static synchronization:- It helps to remove the thread data inconsistancy problem
 * 						   When you create the multiple objects for the particular
 * 						   class/resource and you do not use the static keyword before
 * 						   synchronization it may impact the data inconsistancy so
 * 						   to remove this kind of issue use static synchronization
 * 
 *When you use static synchronization it creates the objects locking and as well as
 *class level locking in this all the thread will pass inside the class one by one
 *it means if one thread is inside the class so all other threads will wait 
 *outside the class until the first thread will get executed/completed or go
 *to the dead state*/

package com.java.threading;

public class StaticSynchronization_17 {}	// This class is not for use only for class file naming purpose



//Program to see the effect without static synchronization(data inconsistancy and thread interference will be occurred)
class BooKTheaterSeat4 {	
	int total_seats = 10;

	//Synchronized method
	synchronized void bookSeats(int seats) {
		if (total_seats >= seats) {
			System.out.println(seats + " Seats booked successfully");
			total_seats -= seats;
			System.out.println("Seats left: " + total_seats);
		} else {
			System.out.println("Sorry "+seats+" seats can not be booked..!!");
			System.out.println("Seats left: " + total_seats);
		}
	}
}

class MovieBookApp4 extends Thread {

	BooKTheaterSeat4 book = new BooKTheaterSeat4();	//tow objects will be created here (It's depend according to the thread called)
	int seat;

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seat);
	}

	public static void main(String[] args) {

		MovieBookApp4 Darsh = new MovieBookApp4();
		Darsh.seat = 7;
		Darsh.start();

		MovieBookApp4 Raj = new MovieBookApp4();
		Raj.seat = 6;
		Raj.start();

	}
};



//Program to see the effect with static synchronization(no data inconsistancy and thread interference will be occurred)
class BooKTheaterSeat5 {	
	static int total_seats = 10;	//when you do the synchronized method as static it will be also static to be accessed inside the static method

	//static synchronized method
	static synchronized void bookSeats(int seats) {
		if (total_seats >= seats) {
			System.out.println(seats + " Seats booked successfully");
			total_seats -= seats;
			System.out.println("Seats left: " + total_seats);
		} else {
			System.out.println("Sorry "+seats+" seats can not be booked..!!");
			System.out.println("Seats left: " + total_seats);
		}
	}
}

class MovieBookApp5 extends Thread {

	BooKTheaterSeat5 book = new BooKTheaterSeat5();	//tow objects will be created here (It's depend according to the thread called)
	int seat;

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seat);
	}

	public static void main(String[] args) {

		MovieBookApp5 Darsh = new MovieBookApp5();
		Darsh.seat = 7;
		Darsh.start();

		MovieBookApp5 Raj = new MovieBookApp5();
		Raj.seat = 6;
		Raj.start();

	}
};



//Other program to get more clarity(program without static synchronization)
class BooKTheaterSeat6 {	
	int total_seats = 20;

	//synchronized method
	synchronized void bookSeats(int seats) {
		if (total_seats >= seats) {
			System.out.println(seats + " Seats booked successfully");
			total_seats -= seats;
			System.out.println("Seats left: " + total_seats);
		} else {
			System.out.println("Sorry "+seats+" seats can not be booked..!!");
			System.out.println("Seats left: " + total_seats);
		}
	}
}
class MyThread1 extends Thread {

	BooKTheaterSeat6 book;
	int seats;
	
	public MyThread1(BooKTheaterSeat6 book, int seats) {

		this.book=book;	//passing object reference to the current class instances
		this.seats=seats;
	}

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seats);
	}
}
class MyThread2 extends Thread {

	BooKTheaterSeat6 book;
	int seats;
	
	public MyThread2(BooKTheaterSeat6 book, int seats) {

		this.book=book;
		this.seats=seats;
	}

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seats);
	}
}

class MobileBookApp6 {
	public static void main(String[] args) {

		//1st object creation
		BooKTheaterSeat6 book1 = new BooKTheaterSeat6();
		MyThread1 t1 = new MyThread1(book1, 7);
		t1.start();
		
		MyThread2 t2 = new MyThread2(book1, 6);
		t2.start();
		
		//2nd object creation
		BooKTheaterSeat6 book2 = new BooKTheaterSeat6();
		MyThread1 t3 = new MyThread1(book2, 5);
		t3.start();
		
		MyThread2 t4 = new MyThread2(book2, 9);	// this seat should not be booked but it's getting booked because static keyword is not used.(data inconsistancy will occur) to overcome multiple object creation use static synchronized method or synchronized static method.
		t4.start();

	}
};

//Other program to get more clarity(program with static synchronization)
class BooKTheaterSeat7 {	
	static int total_seats = 20;

	//synchronized method
	synchronized static void bookSeats(int seats) {	//when you create static synchronized it creates object locking as well as class locking
		if (total_seats >= seats) {
			System.out.println(seats + " Seats booked successfully");
			total_seats -= seats;
			System.out.println("Seats left: " + total_seats);
		} else {
			System.out.println("Sorry "+seats+" seats can not be booked..!!");
			System.out.println("Seats left: " + total_seats);
		}
	}
}
class MyThread3 extends Thread {

	BooKTheaterSeat7 book;
	int seats;
	
	public MyThread3(BooKTheaterSeat7 book, int seats) {

		this.book=book;	//passing object reference to the current class instances
		this.seats=seats;
	}

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seats);
	}
}
class MyThread4 extends Thread {

	BooKTheaterSeat7 book;
	int seats;
	
	public MyThread4(BooKTheaterSeat7 book, int seats) {

		this.book=book;
		this.seats=seats;
	}

	@Override
	public void run() {
		//using method resource
		book.bookSeats(seats);
	}
}

class MobileBookApp7 {
	public static void main(String[] args) {

		//1st object creation
		BooKTheaterSeat7 book1 = new BooKTheaterSeat7();
		MyThread3 t1 = new MyThread3(book1, 7);
		t1.start();
		
		MyThread4 t2 = new MyThread4(book1, 6);
		t2.start();
		
		//2nd object creation
		BooKTheaterSeat7 book2 = new BooKTheaterSeat7();
		MyThread3 t3 = new MyThread3(book2, 5);
		t3.start();
		
		MyThread4 t4 = new MyThread4(book2, 9);
		t4.start();

	}
};
