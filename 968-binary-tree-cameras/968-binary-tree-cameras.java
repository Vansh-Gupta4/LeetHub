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
// Pepcoding:-https://www.youtube.com/watch?v=uoFrIIrp5_g

class Solution {
//     if you need a camera:-1
//     if you have a camera:0
//     if you are covered:1 
    int camera=0;
    public int minCameraCover(TreeNode root) {
        if(cameraNeeded(root)==-1){
            camera++;
        }
        return camera;
    }
    public int cameraNeeded(TreeNode root) {
        if(root==null){
            return 1;
        }
        int lchild=cameraNeeded(root.left);
        int rchild=cameraNeeded(root.right);
        
        if(lchild==-1 || rchild==-1){
            camera++;
            return 0;
        }
        if(lchild==0 || rchild==0){
            return 1;
        }
        return -1;
    }
}