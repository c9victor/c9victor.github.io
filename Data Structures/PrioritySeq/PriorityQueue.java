public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

    private void siftUp(int i) {
        while(i != 1 && heap[i].compareTo(heap[parent(i)]) > 0) {
            Interval temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        while ((left(i) < numElements && heap[i].compareTo(heap[left(i)]) < 0)
            || (right(i) < numElements && heap[i].compareTo(heap[right(i)]) < 0)) {
            Interval temp;
            if (left(i) < numElements && right(i) < numElements) {
                if (heap[left(i)].compareTo(heap[right(i)]) > 0) {
                    temp = heap[left(i)];
                    heap[left(i)] = heap[i];
                    heap[i] = temp;
                    i = left(i);
                } else {
                    temp = heap[right(i)];
                    heap[right(i)] = heap[i];
                    heap[i] = temp;
                    i = right(i);
                }
            } else if (left(i) < numElements && heap[i].compareTo(heap[left(i)]) < 0) {
                temp = heap[left(i)];
                heap[left(i)] = heap[i];
                heap[i] = temp;
                i = left(i);
            } else if (right(i) < numElements && heap[i].compareTo(heap[right(i)]) < 0) {
                temp = heap[right(i)];
                heap[right(i)] = heap[i];
                heap[i] = temp;
                i = right(i);
            }
        }
    }
    
    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }
	
    private int parent(int i) {
        return i / 2;
    }
    
    /**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
            Interval [] bigger = new Interval[size * 2];
            for (int i = 0; i < heap.length; i++) {
                bigger[i] = heap[i];      
            }
            heap = bigger;
            size *= 2;
        }
		// Insert without buffer expansion here.
        heap[numElements] = k;
        siftUp(numElements);             
        numElements++;
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length). See the 
        compareTo function of Interval for more details on the comparison.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
        Interval temp = heap[numElements - 1];
        heap[numElements - 1] = heap[1];
        heap[1] = temp;
        numElements--;
        siftDown(1);
    	
		return heap[numElements];
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i) 
			System.out.println(heap[i]);
    }
}
