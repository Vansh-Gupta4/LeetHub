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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<Double> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            double sum=0;
            double cnt=0;
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                sum+=q.poll().val;
                cnt++;
            }
            double avg=sum/cnt;
            list.add(avg);
        }
        return list;
    }
}