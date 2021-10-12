import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during 
                                        // breadth-first-search. The key field is the word that is visited, 
                                        // and its value field can hold the predecessor pointer.
	private static Queue Q;				// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.
        Q = new Queue();
        R = new StringMap();
        if(bfs()) {
            System.out.println("Yay! A word ladder is possible.");
            print(R.find(end));
        } else
            System.out.println("Duh! Impossible.");
    }

    private static boolean bfs() {
        //putting the start node into the queue
        QNode sNode = new QNode(0, start);
        Q.enqueue(sNode);
        
        while (!Q.isEmpty()) {
            QNode curr = Q.dequeue();
            String s = curr.getWord();
            char arr[] = new char[s.length()];
            for (int i = 0; i < arr.length; i++)
                arr[i] = s.charAt(i);

            //find all valid words that are one letter away
            for (int i = 0; i < s.length(); i++) {
                for (int j = 97; j < 123; j++) {
                    //makes sure we don't check the current word against itself
                    if (s.charAt(i) == (char) j)
                        continue;
                    arr[i] = (char) j;
                    String temp = String.copyValueOf(arr);
                    //if the current word is in R, the node has already been visited
                    if (R.find(temp) != null) 
                        continue;
                    //if the current word is valid we need to insert it into R & queue it
                    if (T.find(temp) != null) {
                        R.insert(temp, s);
                        QNode toQ = new QNode(curr.getDist() + 1, temp);       
                        Q.enqueue(toQ);
                    }
                    //if the current word equals the end, we have found a valid path
                    if (temp.equals(end)) 
                        return true;
                }
                arr[i] = s.charAt(i);
            }
        }
        return false;
    }

    private static void print(StringNode node) {
        if (node.getValue().equals(start) && node.getKey().equals(end)) {
            System.out.println(node.getValue());
            System.out.println(node.getKey());
            return; 
        }
        if (node.getValue().equals(start)) {
            System.out.println(node.getValue());
            return; 
        }
    
        print(R.find(node.getValue()));
        System.out.println(node.getValue());
        
        if (node.getKey().equals(end))
            System.out.println(node.getKey());       
    }
}
