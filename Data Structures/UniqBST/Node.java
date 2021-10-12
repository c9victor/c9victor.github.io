/*
 * This class represents an individual node in a binary search tree.
 */
public class Node {
	
	public int key; 
	public Node left;
	public Node right;
	
	Node (int _key) {
		key = _key;
		left = null;
		right = null;
	}
}
