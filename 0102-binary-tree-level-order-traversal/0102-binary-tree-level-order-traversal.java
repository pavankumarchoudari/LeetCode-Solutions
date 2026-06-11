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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);  
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        
        while(!q.isEmpty()) {
            TreeNode currNode = q.remove();
            
            if(currNode == null) {
            
                result.add(levelList);
                
                if(q.isEmpty()) {
                    break;
                } else {
                    
                    q.add(null);
                    levelList = new ArrayList<>();  
                }
            } else {
                
                levelList.add(currNode.val);
                
                
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        
        return result;
    }
}
