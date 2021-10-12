import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {

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
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word))
	  		System.out.println(word + " is correct.");
        else {
	  		System.out.println("Suggesting alternatives ...");
            //TODO: Code to do the spell checker. Look into the StringSet for all possible 
            //alternatives of the input word mis-spelled by one character.
            
            char arr[] = new char[word.length()];
            for (int i = 0; i < arr.length; i++) 
            {
                arr[i] = word.charAt(i);
            }

		    for (int i = 0; i < word.length(); i++) {
                for (int j = 97; j < 123; j++) { 
                    arr[i] = (char) j;
                    String temp = String.copyValueOf(arr);
                    if(x.find(temp)) {
                        System.out.println(temp);
                    }
                }
                arr[i] = word.charAt(i);
            }
        }
      }	
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 
  } 
}
