/**
	This class implements a circular array.
	It expands if the queue becomes full.
**/
public class Queue {
	private QNode [] queue;		// Array that stores the queue elements.
	private int front;			// Index pointing to the front of the queue.
	private int end;			// Index pointing to the element that is one less than the end of the queue.
	private int numElements;	// The number of elements currently stored in the queue.
	private int size;			// The capacity of the allocated array. If the number of elements reaches this capacity, we need to expand.

	/**
		Constructor: Allocates a queue with inital size of 1000.
	**/
	public Queue() {
		numElements = 0;
		size = 1000; 
		//size = 10; //only for testing
		front = size - 1;
		end = size - 1;
		queue = new QNode[size];
	}
	
	/**
		This function enqueues a new element p into the queue. 
		This also expands the array if it is full.
	**/
	public void enqueue(QNode p) {
		if (numElements == size) {
			// TODO: Expand the array, by first creating another one with twice the size 
            // and copying the contents of the old array.
            copyArray(queue);
        }
        queue[end] = p;
        //System.out.println(p.getWord() + " inserted at end(" + end + "). front: " + front + "\tsize: " + size);
        end = (end - 1 + size) % size;	
        numElements++;
    }

	/**
		This function removes and returns the end front element in the queue.
	**/
	public QNode dequeue() {
		if (numElements == 0) {
			return null;
		}
	    QNode f = queue[front];
        front = (front - 1 + size) % size;
        numElements--;

    	return f;
	}

	/**
		This function returns true if the queue is empty, otherwise returns false.
	**/
	public boolean isEmpty() {
		if (numElements == 0) 
			return true;
		return false;
	}

	/**
		This function prints the contents of the queue.
	**/
	public void print() {
	    //if the array is full
        if (queue[front] == null) return;
         
        if (end == front && numElements == size) {
            for (int i = front; i >= 0; i--) 
                System.out.println(queue[i].getWord());
            for (int i = size - 1; i > front; i--) 
                System.out.println(queue[i].getWord());
        //array is not full and the front precedes the int in the index
        } else if (end < front) {
            for (int i = front; i > end; i--) 
                System.out.println(queue[i].getWord());
        //end precedes the front in the index
        } else {
            for (int i = front; i >= 0; i--) 
                System.out.println(queue[i].getWord());
            for (int i = size - 1; i > end; i--) 
                System.out.println(queue[i].getWord());
        }
    }

	/**
		This function copies the contents of the array passed in, into the queue.
		This is usually called when expanding the array size.
	**/
	private void copyArray(QNode [] array) {
		// TODO: Code to copy the array into queue. Make sure that the queue parameters --
        //  front, end and numElements and size are all set correctly.
    
        //based on insert in StringMap
        int oldSize = size;
        size *= 2;
	    queue = new QNode[size];
        	
        int pos = size - 1;
        for (int i = front; i >= 0; i--, pos--) 
            queue[pos] = array[i];
        for (int i = oldSize - 1; i > front; i--, pos--) 
            queue[pos] = array[i];
        
        front = size - 1;
        end = size - 1 - numElements;
    }
}
