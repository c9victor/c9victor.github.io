public class BST {
	private Node root; // The root node of the tree.
    private Node pred;
    private Node succ;

	public BST() {
		root = pred = succ = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
	    root = insert(root, time, req_index);	
	}

    private Node insert(Node T, int time, int req_index) {
       if (T == null) return new Node(time, req_index);
       if (time < T.getTime())
           T.setLeft(insert(T.getLeft(), time, req_index));
       else if (time > T.getTime())
           T.setRight(insert(T.getRight(), time, req_index));
       return T;
    }

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
        pred = null;
        if (root == null) return null;
	    else return pred(root, time);
    }

    private Node pred(Node t, int time) {
        if (t == null) return pred;
        if (t.getTime() == time) {
            if (t.getLeft() != null) {
                t = t.getLeft();
                while(t.getRight() != null)
                    t = t.getRight();
                return t;   
            }
        } else if (t.getTime() < time) {
            pred = t;
            return pred(t.getRight(), time);
        } else {
            return pred(t.getLeft(), time);
        }
        return pred; 
    }

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	public Node succ(int time) {
        succ = null;
        if (root == null) return null;
        else return succ(root, time);
	}

    private Node succ(Node t, int time) {
        if (t == null) return succ;
        if (t.getTime() == time) {
            if (t.getRight() != null) {
                t = t.getRight();
                while(t.getLeft() != null)
                    t = t.getLeft();
                return t; 
            }
        } else if (t.getTime() < time) {
            return succ(t.getRight(), time); 
        } else {
            succ = t;
            return succ(t.getLeft(), time);
        }
        if (succ != null && succ.getTime() > time) return succ;
        else return null;
    }

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
	public Node min() {
	    if (root == null) return null;
        else return min(root);
    }

    private Node min(Node t) {
        if (t.getLeft() == null) return t;
		else return min(t.getLeft());
    }

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	public Node max() {
        if (root == null) return null;
	    else return max(root);
    }

    private Node max(Node t) {
        if (t.getRight() == null) return t;
		else return max(t.getRight());
    }

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
        root = delete(root, time);	
    }

    private Node delete(Node t, int time) {
        if (t == null) return t;
        if (t.getTime() == time) {
            if (t.getLeft() == null)
                return t.getRight();
            else if (t.getRight() == null)
                return t.getLeft();
            t.setTime(minVal(t.getRight()));
            t.setRight(delete(t.getRight(), t.getTime()));
        } else if (t.getTime() < time) 
            t.setRight(delete(t.getRight(), time));
        else 
            t.setLeft(delete(t.getLeft(), time));
        
        return t;
    }

    private int minVal(Node t) {
        int min = t.getTime();
        while (t.getLeft() != null) {
            min = t.getLeft().getTime();
            t = t.getLeft();
        }
        return min;
    }

	/**
		Prints the contents of the tree in sorted order.
	**/
	public void print() {
        print(root);	
	}

    private void print(Node t) {
        if (t == null) return;
        print(t.getLeft());
        System.out.println(t.getTime());
        print(t.getRight());
    }
}
