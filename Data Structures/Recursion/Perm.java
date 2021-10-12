public class Perm {
    
    public static int n = 5;
    public static int [] rem;
    public static int [] perm;

    public static void printPerm(int f) {
        if (f >= n) {
            // print perm and return.
            for(int i = 0; i < n; i++)
                System.out.print(perm[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (rem[i] != -1) {
                perm[f] = rem[i];
                rem[i] = -1;
                printPerm(f+1);
                rem[i] = perm[f];
                perm[f] = -1;
            }
        }
    }

    public static void main(String [] args) {
        rem = new int[n];
        perm = new int[n];

        for (int i = 0; i < n; i++) {
            rem[i] = i + 1;
            perm[i] = -1;
        }
        printPerm(0);
    }
}
