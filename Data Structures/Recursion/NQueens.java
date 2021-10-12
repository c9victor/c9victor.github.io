import java.util.Scanner;

public class NQueens {
    private static int n;
    private static int solutions = 0;
    private static int board[][];
    
    private static void check_row(int r) {
        if(r >= n) {
            solutions += 1;
            return;
        }
        for (int i = r; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    //places attacking positions.
                    int c = 1;
                    while(i + c < board.length) {
                        if (j + c < board.length) {
                            board[i+c][j+c] += 1;
                        }
                        if (j - c > -1) {
                            board[i+c][j-c] += 1;
                        }
                        board[i+c][j] += 1;
                        c++;
                    }

                    //checks next row.
                    check_row(i + 1);
                   
                    //unplaces attack positions. 
                    c = 1;
                    while(i + c < board.length) {
                        if (j + c < board.length && board[i+c][j+c] > 0) 
                            board[i+c][j+c] -= 1;
                        
                        if (j - c > -1 && board[i+c][j-c] > 0) 
                            board[i+c][j-c] -= 1;
                        
                        if (board[i+c][j] > 0)
                            board[i+c][j] -= 1;
                        c++;
                    }
                    
                    if (j == board.length - 1) return;
                
                //happens if the entire row is filled with X's
                } else if (j == board.length - 1) {
                    return;            
                }
            }                 
        }
    }             
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        n = sc.nextInt();
        board = new int[n][n];

        check_row(0);
        System.out.println("The number of valid arrangements is " + solutions);
    }
}
