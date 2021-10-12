import java.lang.Math;

public class ListSmallest {
	private int smallest = 2000001;
    
    public static void main(String [] args) {
		
		// Creating an instance of MyList.
		MyList L = new MyList();

		// Get the head of the linked list.
		ListNode head = L.getHead();

		// Create an object of this program to avoid static context.
		ListSmallest l = new ListSmallest();

		// head is the head of my linked list L. 
		// TODO: please write a function to print the minimum element 
        // in this list. Please store this in the variable m.
		int m = 0; // store the min in this variable. 
        
        l.keepCalling(head);
        m = l.smallest;

		System.out.println("The smallest is " + m);
	}

    public void keepCalling(ListNode h) {
        int depth = 0;
        if (h != null)
            keepCalling(findSmallest(h, depth));
        else           
            return;          
    }

    public ListNode findSmallest(ListNode h, int depth) {
        if (h == null || depth == 5000)
            return h;
        else {
            if (h.num < smallest)
                smallest = h.num;
            return findSmallest(h.next, depth + 1);
        }
    }
}
