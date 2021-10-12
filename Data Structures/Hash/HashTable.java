public class HashTable {
    private Node[] table;
    private int size;

    public HashTable(int s) {
        size = s;
        table = new Node[size];
    }
     
    public void insert(int val, int k) {
        table[k] = new Node(val, table[k]);    
    }

    public void printRow(int index) { 
        for (Node cur = table[index]; cur != null; cur = cur.next) {
            System.out.println(cur.key);
        }
    }

    public int[] rowToArray(int index, int size) {
        int array[] = new int[size];
        int i = 0;
        
        for (Node cur = table[index]; cur != null; cur = cur.next) {
            array[i] = cur.key;
            i++;
        }

        return array;
    }
}
