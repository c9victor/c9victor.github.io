import java.util.Scanner;

public class Jugs {
    private static int A;
    private static int B;
    private static int C;
    private static int aSol;
    private static int bSol;
    private static boolean visited[][];
    private static int predA[][];
    private static int predB[][];
    private static String path[][];

    private static boolean dfs(int a, int b) {
        if ((a + b) == C) {
            aSol = a;
            bSol = b;
            return true;
        }
        
        visited[a][b] = true;
        boolean found = false;

        //simulating filling a and b
        int y = A;
        int z = B;
        
        if(!visited[y][b]) {
            found |= dfs(y, b);
            predA[y][b] = a;
            predB[y][b] = b;
            path[y][b] = "Fill Jug 1 [a = " + y + ", b = " + b + "]";
        }
        if(!visited[a][z]) {
            found |= dfs(a, z);
            predA[a][z] = a;
            predB[a][z] = b;
            path[a][z] = "Fill Jug 2 [a = " + a + ", b = " + z + "]";
        }
        
        //simulating emptying a and b
        y = 0;
        z = 0;
        if(!visited[y][b]) {
            found |= dfs(y, b);
            predA[y][b] = a;
            predB[y][b] = b;
            path[y][b] = "Empty Jug 2 [a = " + y + ", b = " + b + "]";
        }
        if(!visited[a][z]) {
            found |= dfs(a, z);
            predA[a][z] = a;
            predB[a][z] = b;
            path[a][z] = "Empty Jug 2 [a = " + a + ", b = " + z + "]";
        }

        //simulating pouring b into a
        int amtEmpty = A - a;
        if (amtEmpty <= b) {
            y = A; 
            z = b - amtEmpty;
        } else { 
            y = a + b;
            z = 0;
        }
        if(!visited[y][z]) {
            found |= dfs(y, z);   
            predA[y][z] = a;
            predB[y][z] = b;
            path[y][z] = "Pour Jug 2 -> Jug 1 [a = " + y + ", b = " + z + "]";
        }

        //simulating pouring a into b
        amtEmpty = B - b;
        if (amtEmpty <= a) {
            y = a - amtEmpty;
            z = B;
        } else {
            y = 0;
            z = a + b;   
        }
        if(!visited[y][z]) {
            found |= dfs(y, z);
            predA[y][z] = a;
            predB[y][z] = b;
            path[y][z] = "Pour Jug 1 -> Jug 2 [a = " + y + ", b = " + z + "]";
        }
        
        return found;
    }
    
    private static void print(int a, int b) {
        if (predA[a][b] == -1) return;
        if (predB[a][b] == -1) return;
        
        print(predA[a][b], predB[a][b]);
        System.out.println(path[a][b]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
           
        System.out.print("Enter A: ");
        A = sc.nextInt();
        System.out.print("Enter B: ");
        B = sc.nextInt();
        System.out.print("Enter C: ");
        C = sc.nextInt();

        visited = new boolean[A+1][B+1];
        predA = new int[A+1][B+1];
        predB = new int[A+1][B+1];
        path = new String[A+1][B+1];
                
        for (int i = 0; i < A+1; i++) {
            for (int j = 0; j < B+1; j++) {
                predA[i][j] = -1;
                predB[i][j] = -1;
            }
        }
        
        if(dfs(0, 0)) {
            System.out.println("Yay! Found a solution");
            print(aSol, bSol);
        } else 
            System.out.println("Impossible!");
    }
}
