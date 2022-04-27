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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root,ret);
        return ret;
    }
    public void dfs(TreeNode root, List<Integer> ret) {
         if(root!=null){
            dfs(root.left,ret);
            ret.add(root.val);
            dfs(root.right,ret);
        }
    }
}