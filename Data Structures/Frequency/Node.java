/*
 * This class represents an individual node in hash table.
 */
public class Node {
	
	public String key;
	public int count;
	public Node next;

	Node (String _key, Node _next) {
		key = _key;
		next = _next;
		count = 1;
	}
	
	public void incCount() {
		count++;
	}
}
