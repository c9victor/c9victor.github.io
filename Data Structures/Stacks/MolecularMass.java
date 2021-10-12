import java.io.*;
import java.util.Scanner;

public class MolecularMass { 
    private IntStack stack;
    
    public MolecularMass() {
        stack = new IntStack(); 
    }

    public static void main(String[] args) throws Exception{
        MolecularMass m = new MolecularMass();
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the molecule: ");
        String molecule = s.nextLine();
        
        int mass = m.calculate(molecule);
        
        System.out.println("The Molecular Mass of " + molecule + " is " + mass);
        s.close();
    }
    
    public int calculate(String sr) throws Exception {
        int mass = 0;
        int temp = 0;
        int c = 0;

        for(int i = 0; i < sr.length(); i++) {
            c = sr.charAt(i); 
             
            if (c == 40) {
                stack.push(0);
            }
            else if (c == 67) {
                stack.push(12);
            }
            else if (c == 72) {
                stack.push(1);
            }
            else if (c == 79){
                stack.push(16);
            }
            else if (c >= 50 && c <= 57) {
                c = c - '0';
                
                temp = stack.pop() * c;
                stack.push(temp);
                temp = 0;
            }
            else if (c == 41) {
                int check = stack.pop(); 
                while (check != 0) {
                    temp += check;
                    check = stack.pop();
                }
                stack.push(temp);
                temp = 0; 
            }
        }
        
        int val = stack.pop();
        while (val != -1) {
            mass += val;
            val = stack.pop();
        } 
        
        return mass;
    }
}

