/**
 * @author Andrew Timmons
 * Updated: 07/09/2021 
 * Description: PQueue class creates a process queue to be utilized by the CPUScheduling program.
 */
public class PQueue {
	
	/////////////////////
	// INSTANCE VARIABLES
	/////////////////////
	
	MaxHeap<Process> mh;     //MaxHeap that stores current processes in the PQueue.

	
	/////////////////////
	// CONSTRUCTORS
	/////////////////////
	
	public PQueue() {
		mh = new MaxHeap<Process>();
	}

	
	/////////////////////
	// PUBLIC METHODS
	/////////////////////
	
	/*
	 * Extracts the highest-priority process from the PQueue.
	 * 
	 * Returns - highest-priority Process.
	 */
	public Process dePQueue() {
		return mh.extractMaximum();
	}
	
	/*
	 * Adds the input Process to the PQueue.
	 */
	public void enPQueue(Process p) {
		mh.add(p);
	}
	
	/*
	 * Updates each Process in the PQueue. Updating a process increments their timeNotProcessed
	 *  parameter. If the Process's timeNotProcessed is equal to the input timeToIncrementLevel,
	 *  the Process's priority level is increased, unless it is already at the maximum priority
	 *  level, specified by the input parameter maxLevel. After this occurs, the Process's
	 *  timeToIncrementLevel is reset.
	 */
	public void update(int timeToIncrementLevel, int maxLevel) {
		for(int i = 0; i < mh.getSize(); i++) {
			Process p = mh.getObjectAtIndex(i);
			p.increaseTimeNotProcessed();
			if(p.getTimeNotProcessed() == timeToIncrementLevel) {
				if(p.getPriority() < maxLevel) {
					p.increasePriority();
				}
				p.resetTimeNotProcessed();
				mh.maxHeapifyUp(i);
			}			
		}
	}
	
	/*
	 * Returns - true if the PQueue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return mh.isEmpty();
	}
}
