import java.lang.Integer;

public class Prog {	
    public static void main(String [] args) { 
        		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);
         	
        switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.	         
        for (int i = 0; i < n; i ++) {
            System.out.println(i * n);
        }
    }

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.		   
        for (int i = 0; i < n; i ++) {
            System.out.println(i);
        }
    }

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	
        HashFunctions g = new HashFunctions(n); 
        HashTable table = new HashTable(n);

        int count[] = new int[n];
        int index; 
        
        int prime = 128189;
        for (int i = 0; i < prime; i++) {
            index = g.hash3(i);
            table.insert(i, index);
            count[index] += 1;   
        }
        int lCount = count[0];
        int lIndex = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > lCount) { 
                lCount = count[i];
                lIndex = i; 
            }
        }
        
        int a2[] = table.rowToArray(lIndex, lCount);
        
        if (lCount >= n) {
            table.printRow(lIndex);
        }
        else {
            label:
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < a2.length; i++) {
                    int val = a2[i] + prime * j;
                    table.insert(val, lIndex);
                    lCount++;
                    if (lCount >= n)
                        break label;
                }
            }
            table.printRow(lIndex);
        }
        
    }

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.		
        HashTable table = new HashTable(n);
        HashFunctions g = new HashFunctions(n);
 
        int count[] = new int[n]; 

        for (int i = 0; i < n * n; i++) {
            int index = g.hash4(i);
            table.insert(i, index);
            count[index] += 1;
            if (count[index] == n) {
                table.printRow(index);
                break;
            }
        }  
    }
}
