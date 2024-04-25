/*MULTI-TASKING:- Performing multiple task/job/process/program at single time for 
 *eg.- if in a CPU we are using multiple application at one time like word, browser,  
 *VLC player etc. It increases the performance of the CPU.
 *We can achieve multitasking in 2 types:-
 *1)Process based multitasking(Multi-Processing)
 *2)Thread based multitasking(Multi-Threading)
 *
 *MULTI-PORCESSING:- When one system is connected to multiple processor in orders to
 *complete the task for eg.- one OS(System) is connected to multiple CPUs or processor
 *in order to complete the task-> VLC, Music player, word etc.
 *It is best suitable at system level or OS level.
 *
 *MULTI-THREADING:- Executing multiple threads(sub-process, small task) at single time.
 *eg.- There is an application like VLC player so this a one task and inside the VLC player
 *there are many sub-tasks like video play, music control, video timer etc these are also
 *perform the task simultaneously/together to perform the main task VLC player which is 
 *called thread. It is being used in many softwares like VLC player, in games, in animation
 *etc. And multi-threading is best suitable at programming level
 *Java provide predefined API(class and interface) for multi-threading like Thread, Runnable
 *ThreadGroup, concurrency(package), ThreadPool*/

package com.java.threading;

public class DiffBetweenMultitaskingMultiprocessingAndMultiThreading_1 {}	//This class is not for use only for class file naming purpose.

//Multi-Threading program
//Thread one
class VideoPlay extends Thread {	

	@Override
	public void run() {
		for(int i=1; i<=4; i++)
		System.out.println("Video is playing");
	}
}
//Thread two
class MusicControl extends Thread {

	@Override
	public void run() {
		for(int i=1; i<=4; i++)
		System.out.println("You can control the music");
	}
}
//Thread three
class VideoTime extends Thread {

	@Override
	public void run() {
		for(int i=1; i<=4; i++)
		System.out.println("You can track the video time");
	}
}
//Main process/program
class VlcPlayer{
	
	public static void main(String[] args) {
		//Creating thread
		VideoPlay t1 = new VideoPlay();
		MusicControl t2 = new MusicControl();
		VideoTime t3 = new VideoTime();
		//Calling thread it will run simultaneously
		t1.start();	//thread 1
		t2.start();	//thread 2
		t3.start();	//thread 3
	}
};