import java.util.Scanner;

/* This class uses a dictionary data structure to print unique 
 * elements in the input.
 */
public class Unique {

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		BST t = new BST();
		//HashTable t = new HashTable(10000);

		while (sc.hasNext()) {
			int key = sc.nextInt();
			if (!t.find(key))			// Only keys that are not currently in the hash table are inserted.
				t.insert(key);
		}
		t.print();
	}
}
