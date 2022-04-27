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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ret = new ArrayList<>();
    //     dfs(root,ret);
    //     return ret;
    // }
    // public void dfs(TreeNode root, List<Integer> ret) {
    //      if(root!=null){
    //         dfs(root.left,ret);
    //         ret.add(root.val);
    //         dfs(root.right,ret);
    //     }
    // }
    
//     ITERATIVE APPROACH
    public List<Integer> inorderTraversal(TreeNode curr) {
        ArrayList < Integer > inOrder = new ArrayList < > ();
        Stack < TreeNode > s = new Stack <> ();
        while(true){
            if(curr!=null){
                 s.push(curr);
                curr=curr.left;
            }else{
                if(s.isEmpty()){
                    break;
                }else{
                    curr=s.peek();
                    inOrder.add(curr.val);
                    s.pop();
                    curr=curr.right;
                }
            }
        }
        return inOrder;
    }
}