import java.util.Random;

/**
 * @author Andrew Timmons
 * Updated: 07/09/2021
 * Description: ProcessGenerator class is used by the CPUScheduling program to generate Processes at a specified rate. A random number generator is
 * 				 utilized to simulate this process arrival rate.
 */
public class ProcessGenerator {
	
	/////////////////////
	// INSTANCE VARIABLES
	/////////////////////
	
	Random rng;				//Random object used for queries and generating randomized Processes.
	double probability;     //Probability used for querying the ProcessGenerator; mimics the process arrival rate.
	
	
	/////////////////////
	// CONSTRUCTORS
	/////////////////////
	
	public ProcessGenerator(double probability) {
		this.probability = probability;
		rng = new Random();
	}
	
	
	/////////////////////
	// PUBLIC METHODS
	/////////////////////
	
	/*
	 * Calls to query by CPUScheduling are designed to simulate the process arrival rate, which is equal to the
	 *  probability instance variable. When called, a random double between 0 and 1 is generated and compared
	 *  to the probability. Because the function only returns true when the random double is less than or equal
	 *  to the probability, the function will effectively return true (probability * 100) percent of the time.
	 *  When this occurs, CPUScheduling will then use getNewProcess to generate a new Process for the PQueue.
	 *  
	 * Returns - true if the randomly generated double is less than or equal to the probability instance
	 *  variable, false otherwise.
	 */
	public boolean query() {
		return rng.nextDouble() <= probability;
	}
	
	/*
	 * Generates a new Process object with the arrivalTime specified by the input currentTime. The Process's
	 *  timeRemaining and priority instance variables are randomly generated using the input parameters
	 *  maxProcessTime and maxLevel to specify the upper bounds.
	 *  
	 * Returns - randomly generated Process.
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int processTime = rng.nextInt(maxProcessTime) + 1;
		int maxPriority = rng.nextInt(maxLevel) + 1;
		
		Process p = new Process(currentTime, processTime, maxPriority);
		
		return p;
	}

}
