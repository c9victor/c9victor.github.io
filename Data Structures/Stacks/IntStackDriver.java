public class IntStackDriver {
    public static void main(String[] args) {
        IntStack s = new IntStack();

        for(int i = 0; i < 101; i++) {
            System.out.println("Pushing: " + i);
            s.push(i);
        } 

        for (int i = 0; i < 101; i++) {
            System.out.print(s.pop() + " ");
        }
    }
}
