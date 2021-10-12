import java.util.Scanner;

/*
 * Thi class computes the most frequently occurring word in an input text file.
 */
public class Frequency {

	public static void main(String [] args) {

		Scanner kb = new Scanner(System.in);
		HashTable t = new HashTable(180000);

		while (kb.hasNext()) {
			String key = kb.nextLine();
			Node cur = t.find(key);
			
			// If the node is already present, increment its count. Otherwise, just insert.
			if (cur != null) {
				cur.incCount();
			}
			else 
				t.insert(key);
		}
		t.print();

		/*
		Node max = t.frequent();
		if (max != null) {
			System.out.println("The most frequent word in LOTR is: " + max.key + " " + max.count);
		}
		*/
	}
}
