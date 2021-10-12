/*
 * This class maintains a set of ints. 
 */
public class IntSet {	
    private Node head; //Head of the linked list. 

    public IntSet() { 
        head = null;   
    } 
    
    public boolean find(int key) {
        Node find = head;
        
        while(find != null) {
            if (find.digit == key) {
                return true;
            } 
            find = find.next;   
        }
        return false;
    }

    /** Insert a key into the set */
    public void insert(int key) {
        //Makes sure that the key is not present
        assert (!find(key));
        
        Node newNode = new Node(key, null);

        if (head == null) { 
            head = newNode;
            return;   
        }

        if (newNode.digit < head.digit) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node previous = null;
        Node t = head;

        while (t != null) {
            if (key > t.digit) {
               previous = t;
               t = t.next; 
            }
            else {
                break;
            }
        }

        newNode.next = previous.next;
        previous.next = newNode;   
    }

    public void remove(int key) {
        assert (find(key));
                
        if (head != null && key == head.digit) {
            head = head.next;
        }
        
        Node previous = null;
        Node t = head;

        while (t != null) {
            if (key != t.digit) {
                previous = t;
                t = t.next;
            }
            else {
                break;
            }
        }
        
        if (previous.next != null) {
            previous.next = previous.next.next;
        }
    }

    public void print() {
        if (head != null) {
            for(Node i = head; i != null; i = i.next) {
                System.out.print(i.digit + " ");
            }   
        }
        System.out.println();              
    }
}
