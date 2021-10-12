public class IntStack {
	// May create private data here.
    private Node head; 
    private int size;

	public IntStack() {
		// TODO: Code to initialize your stack.
	    head = null;
        size = 0;
    }

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
	    if (size < 100) {
            Node n = new Node(x, head);
            head = n;
            size++;
        }
    }

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
	    if (size == 0) {
            return -1;
        }
        
        int val = head.digit;
        head = head.next;
        size--;
        return val;
    }
}
