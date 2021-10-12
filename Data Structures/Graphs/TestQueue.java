public class TestQueue {
    //methods to test: enqueue, dequeue, print, copyArray
    public static void main(String[] args) {
        Queue q = new Queue();

        int dist = 0;
        System.out.println("Test set one:");
        for(int i = 0; i < 21; i++) {
            String s = Integer.toString(i);
            QNode node = new QNode(dist, s);
            q.enqueue(node);
            dist++;
        }
        System.out.println("Printing queue...");
        q.print();
        
        System.out.println("\n\nTest set two:");
        q = new Queue();
        dist = 0;

        for (int i = 0; i < 5; i++){
            String s = Integer.toString(i);
            QNode node = new QNode(dist, s);
            q.enqueue(node);
            dist++;
        }
        System.out.println("Removing two elements");
        q.dequeue();
        q.dequeue();
        System.out.println("Printing queue...");
        q.print();

        System.out.println("Adding 10");
        QNode n = new QNode(dist, "10");
        q.enqueue(n);
        System.out.println("Printing queue...");
        q.print();

        System.out.println("Removing all elements");
        for (int i = 0; i < 5; i++)
            q.dequeue();
        System.out.println("Printing queue...");
        q.print();
    }
}
