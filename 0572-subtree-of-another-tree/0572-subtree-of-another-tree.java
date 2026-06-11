/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (root == null) {
            return false;  // If root is null, subRoot can't be a subtree
        }
        // If root and subRoot match, check if they are identical
        if (root.val == subRoot.val && isIdentical(root, subRoot)) {
            return true;
        }
        // Recursively check the left and right subtrees of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}