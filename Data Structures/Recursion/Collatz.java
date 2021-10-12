import java.util.Scanner;

public class Collatz {
    private static int table[];
    private static final int a = 1;
    private static final int b = 100000000;
    
    private static long collatzLength(long x) {
        if (x == 1) return 1;
        if (x < table.length && table[(int)x] != 0) return table[(int)x];
        if (x % 2 == 0) 
            x = x / 2;
        else
            x = 3 * x + 1;
        return collatzLength(x) + 1;
    }

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        table = new int[b + 1];
        //System.out.println("Enter the range: " + a + " " + b);
        System.out.print("Enter the range: ");
        int c = kb.nextInt();
        int d = kb.nextInt();
        
        if (c < 1 || d > 100000000 || c > d)
            throw new Exception("Invalid range entered");

        long max = a;
        long length = 1;
        for (int i = c; i <= d; i++) {
            long x = collatzLength(i);
            table[i] = (int)x;
            if (table[i] > length) {
                max = i;
                length = table[i];
            }
        }
        System.out.println("The number with the maximum Collatz length in the range: " + max);
        System.out.println("Its Collatz length: " + length);
    }
}
