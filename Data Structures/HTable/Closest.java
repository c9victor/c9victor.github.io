import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Closest {
    DoubleNode [][] grid;
    int b = 100; 

    public Closest() {
        grid = new DoubleNode[b][b];
    }

    public static void main(String[] args) {
        Closest c = new Closest();
        File file = new File("points.txt");

        try {
            Scanner scanner = new Scanner(file);    
            
            while(scanner.hasNext()) {
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                c.insert(x, y);
            }
        
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + file.getAbsolutePath());
            System.out.println(e);
        }
        
        c.findMinDistance();
    }

    public void findMinDistance() {
        double min = 100.0;
        
        for (int col = 0; col < b; col++) {
            for(int row = 0; row < b; row++) { 
                DoubleNode cur = grid[row][col]; 
                for (int i = col - 1; i <= col + 1; i++) {
                    for(int j = row - 1; j <= row + 1; j++) {
                        //avoids Array Out Of Bounds Exceptions
                        if (i > -1 && i < b && j > -1 && j < b) {
                            //compare to all values in that grid
                            for (DoubleNode k = grid[i][j]; k != null; k = k.getNext()) {
                                double temp = Math.sqrt(Math.pow((cur.getX() - k.getX()), 2) 
                                    + Math.pow((cur.getY() - k.getY()), 2)); 
                                //temp != 0.0 because the program will compare points to themselves
                                if (temp < min && temp != 0.0) 
                                    min = temp; 
                            }
                        }
                    }
                }
            }
        }
           
        System.out.println("The closest pair of points is: " + min); 
    }

    public void insert(double x, double y) { 
            int hashVals[] = hash(x, y);
            int i = hashVals[0];
            int j = hashVals[1];
            grid[i][j] = new DoubleNode(x, y, grid[i][j]);
    }
    
    public boolean find(double x, double y) { 
        int hashVals[] = hash(x, y);
        int i = hashVals[0];
        int j = hashVals[1];

        for (DoubleNode cur = grid[i][j]; cur != null; cur = cur.getNext()) {
            if (x == cur.getX() && y == cur.getY()) {
                return true;
            }
        }
        return false;
    }

    public void print() {  
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                for (DoubleNode cur = grid[i][j]; cur != null; cur = cur.getNext()) {
                    System.out.println(cur.getX() + ", " + cur.getY());
                }
            }
        } 
    }

    private int[] hash(double x, double y) {
        int h[] = new int[2];
        h[0] = (int)(x * b);
        h[1] = (int)(y * b);  
        
        return h;
    }    
}
