import java.util.Scanner;

public class Unique {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        HashTable s = new HashTable(10);

        while(kb.hasNext()) {
            int key = kb.nextInt();

            if (!s.find(key)) {
                s.insert(key);
            }
        }
        s.print();
    }
}
