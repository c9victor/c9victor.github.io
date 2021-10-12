import java.util.Random;

public class Test {
    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue(5);

        for(int i = 1; i < 20; i++) {
            Interval inter = new Interval(i, i * 2);
            p.insert(inter);            
        }

        p.print();
        System.out.println("\nRemoving max...");
        System.out.println("Max: " + p.remove_max());
        p.print();
        System.out.println("\nRemoving all elements...");
        int j = 0;
        while(j < 25) {
            p.remove_max();
            j++;
        }
        p.print();
    }
}
