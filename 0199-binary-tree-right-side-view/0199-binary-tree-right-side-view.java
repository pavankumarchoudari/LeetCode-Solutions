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
      List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
      
        if(root == null) return ans;
        rightside( root,0);
        return ans;

        
    }
    void  rightside(TreeNode root, int level){
        TreeNode node = root;
        if(node == null) return;
        if(level == ans.size()) {
            ans.add(node.val);
        }

        rightside(node.right,level+1);
        rightside(node.left,level+1);

    }
}