/**
 * @author Andrew Timmons
 * Updated: 07/09/2021
 * Description: Process class creates a Process to be used in the CPUScheduling program. 
 */
public class Process implements Comparable<Process> {
	
	/////////////////////
	// INSTANCE VARIABLES
	/////////////////////

	int priority;			  //Priority level of the Process.
	int arrivalTime;  		  //Time that the Process was created.
	int timeRemaining;		  //Time remaining until the Process is completed.
	int timeNotProcessed;     //Time that the Process has not been processed.
	
	
	/////////////////////
	// CONSTRUCTORS
	/////////////////////
	
	public Process(int arrivalTime, int timeRemaining, int priority) {
		this.arrivalTime = arrivalTime;
		this.timeRemaining = timeRemaining;
		this.priority = priority;
		timeNotProcessed = 0;
	}
	
	
	/////////////////////
	// PUBLIC METHODS
	/////////////////////
	
	/*
	 * Compares this Process to the input Process. Processes are compared by their
	 *  priority level and arrival times. 
	 *  
	 * Returns - 1 if this Process is greater than the input Process, -1 if it is
	 *  smaller, and 0 if the two are equal.
	 */
	public int compareTo(Process process) {
		if(priority > process.getPriority()) 
			return 1;
		else if(priority < process.getPriority())
			return -1;
		else {
			if(arrivalTime < process.getArrivalTime())
				return 1;
			else if(arrivalTime > process.getArrivalTime())
				return -1;
		}
		return 0;
	}
	
	/*
	 * Decrements the Process's timeRemaining.
	 */
	public void reduceTimeRemaining() {
		timeRemaining--;
	}
	
	/*
	 * Increments the Process's priority level.
	 */
	public void increasePriority() {
		priority++;
	}
	
	/*
	 * Increments the Process's timeNotProcessed.
	 */
	public void increaseTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	/*
	 * Sets the Process's timeNotProcessed to zero.
	 */
	public void resetTimeNotProcessed(){
		timeNotProcessed = 0;
	}
	
	/*
	 * Returns - true if the Process is finished (timeRemaining is zero).
	 */
	public boolean finish() {
		return timeRemaining == 0;
	}
	
	/*
	 * Returns - the priority level of the Process.
	 */
	public int getPriority() {
		return priority;
	}
	
	/*
	 * Returns - the arrival time of the Process.
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/*
	 * Returns - the processing time remaining until the Process is finished.
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	/*
	 * Returns - the amount of time units that the Process has not been processed.
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
}
