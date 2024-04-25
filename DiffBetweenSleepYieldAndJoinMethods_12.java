/*Difference between sleep(), yield() and join() methods:- These all 3 methods temporary stops the thread execution.  
 *sleep():-
 *1) purpose: If any thread does not want to perform any operation for particular time.
 *2) Example: Timer, PPT, Blinking bulbs
 *3) How the thread invokes again?: i)Automatically after provides time periods 
 *									ii)If thread is interrupted
 *4) Methods: i)sleep(long ms) ii)sleep(long ms, int ns)
 *5) Is method overloaded: Yes
 *6) Exception: Yes(InterruptedException)
 *7) Is method final: No
 *8) Is method static: Yes
 *9) Is method native: i)native-sleep(long ms) ii)non-native-sleep(long ms, int ns)
 *
 *yield():-
 *1) purpose: It stops the current executing thread & provide chance to another thread if
 *			  same of higher priority to execute.
 *2) Example: shopping(billing counter)
 *3) How the thread invokes again?: Automatically invoked by thread-scheduler
 *4) Methods: yield()
 *5) Is method overloaded: No
 *6) Exception: No
 *7) Is method final: No
 *8) Is method static: Yes
 *9) Is method native: Yes
 *
 *join():-
 *1) purpose: If a thread wants to wait for another thread to complete it's task.
 *2) Example: Licence dept.
 *3) How the thread invokes again?: i)Automatically invokes after completion of another thread task.
 *									ii)After completion of time period.
 *									iii)If thread is interrupted.
 *4) Methods: i)join() ii)join(long ms) iii)join(long ms, int ns)
 *5) Is method overloaded: Yes
 *6) Exception: Yes(InterruptedException)
 *7) Is method final: Yes
 *8) Is method static: No
 *9) Is method native: No
 **/

package com.java.threading;

public class DiffBetweenSleepYieldAndJoinMethods_12 {}	// This class is not for use only for class file naming purpose