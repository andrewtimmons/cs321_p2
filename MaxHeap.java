import java.util.ArrayList;

/**
 * @author Andrew Timmons
 * Updated: 07/09/2021
 * Description: MaxHeap class creates a list of comparable objects structured as a max heap.
 */
public class MaxHeap<T extends Comparable<T>> {
	
	/////////////////////
	// INSTANCE VARIABLES
	/////////////////////
	
	ArrayList<T> heap;		//Holds the contents of the MaxHeap in an ArrayList.
	
	
	/////////////////////
	// CONSTRUCTORS
	/////////////////////
	
	/*
	 * Creates an empty MaxHeap.
	 */
	public MaxHeap() {
		heap = new ArrayList<T>();
	}
	
	/*
	 * Creates a MaxHeap using the input ArrayList.
	 */
	public MaxHeap(ArrayList<T> inputArrayList) {
		this.heap = inputArrayList;
		if(!isEmpty())
			maxHeapifyDown(0);
	}
	
	/* 
	 * Creates a MaxHeap using the input array.
	 */
	public MaxHeap(T[] inputArray) {
		ArrayList<T> al = new ArrayList<T>(inputArray.length);
		for(int i = 0; i < inputArray.length; i++)
			al.add(i, inputArray[i]);
		
		this.heap = al;
		if(!isEmpty())
			maxHeapifyDown(0);
	}
	
	
	/////////////////////
	// PUBLIC METHODS
	/////////////////////
	
	/*
	 * Organizes the heap into a MaxHeap structure. Organizing starts from the
	 *  input index node and progresses downward using recursive function calls.
	 */
	public void maxHeapifyDown(int index) {
		T child1, child2;
		int child1Index = ((index + 1) * 2) - 1;
		int child2Index = (index + 1) * 2;
				
		try {
			child1 = heap.get(child1Index);
		} catch (IndexOutOfBoundsException e){
			return; //No children means MaxHeapifyDown is finished
		}
		
		try {
			child2 =heap.get(child2Index);
		} catch (IndexOutOfBoundsException e) {
			child2 = null;
		}
		
		if(child2 == null) {
			if(heap.get(index).compareTo(child1) < 0) 
				swapNode(index, child1Index);
			
			maxHeapifyDown(child1Index);
			maxHeapifyUp(index);
		} else {
			if(child1.compareTo(child2) > 0) {
				if(heap.get(index).compareTo(child1) < 0) 
					swapNode(index, child1Index);								
			} else {
				if(heap.get(index).compareTo(child2) < 0) 
					swapNode(index, child2Index);		
			}
			maxHeapifyDown(child1Index);
			maxHeapifyDown(child2Index);
			maxHeapifyUp(index);
		}	
	}
	
	/*
	 * Organizes the heap into a MaxHeap structure. Organizing starts from the 
	 *  input index and progresses upwards using recursive function calls.
	 */
	public void maxHeapifyUp(int index) {
		T parent;
		int parentIndex = (index - 1) / 2;
		
		try {
			parent = heap.get(parentIndex);
		} catch(IndexOutOfBoundsException e) {	
			return; //No parent means MAxHeapifyUp is finished
		}
		
		if(heap.get(index).compareTo(parent) > 0) {
			swapNode(index, parentIndex);
			maxHeapifyUp(parentIndex);
			maxHeapifyDown(parentIndex);
		}			
	}
	
	/*
	 * Removes the maximal element of the MaxHeap. Note that the MaxHeap 
	 *  retains its max heap structure.
	 *  
	 * Returns - maximal element of the MaxHeap.
	 */
	public T extractMaximum() {
		if(isEmpty()) {
			return null;
		}
		T max = heap.get(0);
		remove(0);
		maxHeapifyDown(0);
		return max;
	}

	/*
	 * Adds the input element to its sorted position within the MaxHeap.
	 */
	public void add(T node) {
		heap.add(node);
		maxHeapifyUp(heap.size() - 1);
	}
	
	/*
	 * Removes the element at the given location within the MaxHeap.
	 */
	public void remove(int index) {
		if(index < 0 || index > heap.size()) {
			//error message
			return;
		}
		swapNode(index, getSize() - 1);
		heap.remove(getSize() - 1);
	}
	
	/*
	 * Returns - true if the MaxHeap is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	/*
	 * Returns - the element at the input index of the MaxHeap.
	 */
	public T getObjectAtIndex(int index) {
		return heap.get(index);
	}
	
	/*
	 * Returns - the number of elements in the MaxHeap.
	 */
	public int getSize() {
		return heap.size();
	}
	

	/////////////////////
	// PRIVATE METHODS
	/////////////////////
	
	/*
	 * Swaps the nodes at index1 and index2 of the MaxHeap.
	 */
	private void swapNode(int index1, int index2){
		T temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	
}
