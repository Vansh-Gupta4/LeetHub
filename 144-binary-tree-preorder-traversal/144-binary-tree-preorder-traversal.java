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
    // RECURSIVE APPROACH
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ret = new ArrayList<>();
    //     dfs(root,ret);
    //     return ret;
    // }
    // public void dfs(TreeNode root, List<Integer> ret) {
    //      if(root!=null){
    //         ret.add(root.val);
    //         dfs(root.left,ret);
    //         dfs(root.right,ret);
    //     }
    // }
    
    //ITERATIVE APPROACH
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList < Integer > preOrder = new ArrayList < Integer > ();
        Stack < TreeNode > s = new Stack < > ();
        if(root==null){
            return preOrder;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode topNode = s.peek();
            preOrder.add(topNode.val);
            s.pop();
            if(topNode.right!=null){
                s.push(topNode.right);
            }
            if(topNode.left!=null){
                s.push(topNode.left);
            }
        }
        return preOrder;
    }
}