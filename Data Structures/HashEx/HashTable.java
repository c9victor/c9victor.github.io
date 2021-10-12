public class HashTable {
    private Node[] table;
    private int size;

    public HashTable(int s) {
        size = s;
        table = new Node[size];
    }

    private int hash(int k) {
        return (2971 * k + 101923) % size;
    }

    public void insert(int k) {
        int i = hash(k);
        table[i] = new Node(k, table[i]);
    }

    public boolean find(int k) {
        int i = hash(k);
        
        for (Node cur = table[i]; cur != null; cur = cur.next) {
            if (k == cur.key) {
                return true;
            }
        }

        return false;
    }

    public void print() {   
        for (int i = 0; i < size; i++) {
            for (Node cur = table[i]; cur != null; cur = cur.next) {
                System.out.println(cur.key);
            }
        }
    }
}
