public class MaxHeapUnitTester {
	
	public static void main(String[] args) {
		printMaxHeap(maxHeapTest1());
		printMaxHeap(maxHeapTest2());
		printMaxHeap(maxHeapTest3());
		
		System.out.println();
		printMaxHeap(extractMaxTester1());
		System.out.println();
		printMaxHeap(extractMaxTester2());
		
		System.out.println();
		printMaxHeap(addNodeTester1());
	}
	
	public static MaxHeap<String> maxHeapTest1(){
		String[] array = {"c", "e", "i", "a", "b", "k"};
		MaxHeap<String> maxHeap = new MaxHeap<String>(array);
		
		return maxHeap;
	}
	
	public static MaxHeap<String> maxHeapTest2(){
		String[] array = {"z", "w", "a", "h", "m", "p", "b", "x", "p", "u", "f"};
		MaxHeap<String> maxHeap = new MaxHeap<String>(array);
		
		return maxHeap;
	}
	
	public static MaxHeap<String> maxHeapTest3(){
		String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q" , "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		MaxHeap<String> maxHeap = new MaxHeap<String>(array);
		
		return maxHeap;
	}
	
	public static MaxHeap<String> extractMaxTester1() {
    MaxHeap<String> mh = maxHeapTest3();
	String str = (mh.extractMaximum());
	System.out.println(str);

	return mh;
	}
	
	public static MaxHeap<String> extractMaxTester2() {;
	    MaxHeap<String> mh = maxHeapTest3();
		for(int i = 0; i < 5; i++) {
			String str = (mh.extractMaximum());
			System.out.println(str);
		}
		return mh;
	}
	
	public static MaxHeap<String> addNodeTester1(){
		MaxHeap<String> mh = maxHeapTest2();
		mh.add("y");
		return mh;
	}
	
	public static String toString(MaxHeap<String> mh) {
		String str = "{";
		for(int i = 0; i < mh.getSize() - 1; i++) {
			str += mh.getObjectAtIndex(i) + ", ";
		}
		str += mh.getObjectAtIndex(mh.getSize() - 1) + "}";
		return str;
	}
	
	public static void printMaxHeap(MaxHeap<String> mh) {
		System.out.println(toString(mh));
	}
}
