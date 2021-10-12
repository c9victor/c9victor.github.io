/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructor: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head
   * of the linked list given by its hash value.
   */
  public void insert(String key) {
    numelements++;
    if (numelements == size) {
      //TODO: need to expand the hash table and rehash its contents. 
      size *= 2;
      StringNode[] newTable = new StringNode[size];
      
      for (int i = 0; i < size / 2; i++) {  
        for (StringNode cur = table[i]; cur != null; cur = cur.getNext()) {
            int j = hash(cur.getKey());
            newTable[j] = new StringNode(cur.getKey(), newTable[j]); 
        }
      } 
      table = newTable;     
    }
    //TODO: Code for actual insert.
    int i = hash(key);
    table[i] = new StringNode(key, table[i]);
  }

  /*
   * finds if a String key is present in the data 
   * structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    // TODO:
    int i = hash(key); 
    for (StringNode cur = table[i]; cur != null; cur = cur.getNext()) {
        if (key.equals(cur.getKey())) {
            return true;
        }
    }

    return false;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    // TODO:
    for (int i = 0; i < size; i++) {
        for (StringNode cur = table[i]; cur != null; cur = cur.getNext()) {
            System.out.println(cur.getKey());
        }
    }
  }

  /* 
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String key) {
    int h = 0;
    // TODO: Compute a polynomial hash function for the String k. 
    // Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
    int x = 1277;
    
    for (int i = 0; i < key.length(); i++) {
        h = (h * x + key.charAt(i)) % size; 
    }

    return h;
  }

}
