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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        boolean lefttoRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
          
            for(int i=0;i<size;i++){
                TreeNode node =   queue.poll();
                int index = lefttoRight?i:size-1-i;
                while(row.size()<size){
                    row.add(0);
                }
                row.set(index,node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);


            }
             lefttoRight = !lefttoRight;
        result.add(row);
        }
       
        return result;

        
    }
}