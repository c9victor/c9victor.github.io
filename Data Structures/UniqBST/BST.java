
public class BST {
	private Node root; // Reference to the root node of the BST.	

	/*
		 Constructor.
	*/
	public BST() {
		root = null;
	}

	/*
		 Wrapper method that calls our recursive print function.
	*/
	public void print() {
		print(root);
	}
	/*
		Prints the BST by doing an inorder traversal.
	*/
	private void print(Node T) {
		if (T == null) return;
		print(T.left);
		System.out.println(T.key);
		print(T.right);
	}

	/*
		 Wrapper method to call our find function on a key. Calls our recursive find function.
		 Returns true if key is present, else returns false.
	*/
	public boolean find(int key) {
		return find(root, key);
	}
	/*
		 Recursive routing to find if a key is present.
	*/
	private boolean find(Node T, int key) {
		if (T == null) return false;
		if (T.key == key) return true;
		if (key < T.key) return find(T.left, key);
		return find(T.right, key);
	}
	
	/*
		 Wrappper method to insert a new key into the BST. Calls our recursive insert function.
	*/
	public void insert(int key) {
		root = insert(root, key);
	}
	/*
		 Recursive routine to insert a key into the subtree rooted at T.
		 Returns the root node of the subtree in which the key is being inserted.
	*/
	private Node insert(Node T, int key) {
		if (T == null) return new Node(key);
		if (key <= T.key)
			T.left = insert(T.left, key);
		else 
			T.right = insert(T.right, key);
		return T;
	}
}
