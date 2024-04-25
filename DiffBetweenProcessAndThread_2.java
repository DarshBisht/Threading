/*PROCESS:- 
 *1)A program which is in executing state.
 *  It is a heavy weight because in a main process inside that process there are
 *  many sub process for eg.- VLC player is a main process it's sub process is
 *  video, music, time etc.
 *2)Context Switching:- It takes more time between processes.
 *	Definition of context switching: A context switching is a process that involves
 *  switching of the CPU from one process or task to another. In this phenomenon, the
 *  executing of the process that is present in the running state is suspended by the
 *  kernel and another process that is present in the ready state is executed by the CPU.
 *  It is one of the essential features of the multitasking operating system. The processes
 *  are switched so fastly that it give an illusion to the user that all the processes are
 *  being executed at the same time.
 *3)Communication:- It takes more time between processes.
 *4)Address Process:- Each process has different address space.
 *5)Dependency:- Process are not dependent on each-other.
 *6)Synchronization:- Process does not require synchronization.
 *	Definition of synchronization: When we start two or more threads within a program,
 *	there may be a situation when multiple threads try to access the same resource and
 *	finally they can produce unforeseen result due to concurrency issues. For example,
 *	if multiple threads try to write within a same file then they may corrupt the data
 *	because one of the threads can override data or while one thread is opening the same
 *	file at the same time another thread might be closing the same file. So in this type
 *	of situation we use SYNCHRONIZATION.
 *7)Resource Consumption:- It is more.
 *8)Time of creation:- It takes more time to creation.
 *9)Time for termination:- more time 
 * 
 *THREAD:-
 *1)It is sub part of process(small process).
 *	It is a light weight because it handles the sub part of the main process. 
 *2)Context Switching"- It takes less time between threads.
 *3)Communication:- It takes less time between threads.
 *4)Address Process:- Threads share same address space.
 *5)Dependency:- Threads are dependent on each-other.
 *6)Synchronization:- Threads may require synchronization.
 *7)Resource Consumption:- It is less.
 *8)Time of creation:- It takes less time to creation.
 *9)Time for termination:- less time
 **/

package com.java.threading;

public class DiffBetweenProcessAndThread_2 {}	//This class is not for use only for class file naming purpose.
