
public class DepthPrint {
    private String s = "";

	public static void main(String [] args) {
        // Create an instance of MyTree.		
        MyTree T = new MyTree();

        // Get the root node of my tree.
		TreeNode root = T.getRoot();


		// TODO: Code for printing the tree from depth 500 through 510 in sorted order.
		// Feel free to define recursive methods to traverse the tree and print.
		// Please print each key separated by spaces.
        DepthPrint d = new DepthPrint();
    
        d.findVals(root);
        System.out.println(d.s);
	}

    public void findVals(TreeNode r) {
        int depth = 0;
        findVals(r, depth);
    }

    private void findVals(TreeNode r, int depth1) {
        if (r == null) return;
        findVals(r.left, depth1 + 1); 
        if (depth1 < 511 && depth1 > 499) 
            s += r.key + " ";  
        findVals(r.right, depth1 + 1);    
    }
}
