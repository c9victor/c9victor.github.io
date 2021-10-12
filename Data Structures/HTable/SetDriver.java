import java.util.Scanner;
import java.io.*;

public class SetDriver {
    public static void main(String[] args) {
 
        File f = new File("dictionary");

        try {
            Scanner sk = new Scanner(f);

            StringSet x = new StringSet();

        // Read in the entire dictionary...
        while (sk.hasNext()) {
            String word = sk.next();
            x.insert(word);
        }
        System.out.println("Dictionary loaded...");

        //x.print();

        String a = "coee";
         
        if (x.find(a))
            System.out.println(a + " found");
        else {
            System.out.println("Suggesting alternatives ...");

            char arr[] = new char[a.length()];
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = a.charAt(i);
            }

            for (int i = 0; i < a.length(); i++) {
                for (int j = 97; j < 123; j++) {
                    arr[i] = (char) j; 

                    String temp = String.copyValueOf(arr);
                    if(x.find(temp)) {
                        System.out.println(temp);
                    }
                }
                arr[i] = a.charAt(i);
            }
        }
            

      } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
      }
    }
}
