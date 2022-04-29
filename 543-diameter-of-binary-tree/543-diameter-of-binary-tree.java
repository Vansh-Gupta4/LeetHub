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
    public int diameterOfBinaryTree(TreeNode root) {
         if (root == null){
            return 0;
        }
        int max=0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int leftdm = diameterOfBinaryTree(root.left);
        int rightdm = diameterOfBinaryTree(root.right);

        max=Math.max((leftHeight+rightHeight),Math.max(leftdm,rightdm));

        return max;
    }
    
    public int getHeight (TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}