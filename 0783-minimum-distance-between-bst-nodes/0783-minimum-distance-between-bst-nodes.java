class Solution {
    private Integer prev = null;  // Store the previous node's value
    private int minDiff = Integer.MAX_VALUE;  // Store the minimum difference
    
    public int minDiffInBST(TreeNode root) {
        inorder(root);  // Start inorder traversal
        return minDiff;  // Return the minimum difference
    }

    // Inorder traversal function
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorder(root.left);
        
        // If this is not the first node, compute the difference
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        
        // Update the previous node's value to the current node's value
        prev = root.val;
        
        // Traverse the right subtree
        inorder(root.right);
    }
}
