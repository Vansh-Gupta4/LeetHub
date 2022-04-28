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
    //RECURSIVE Solution
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ret = new ArrayList<>();
    //     dfs(root,ret);
    //     return ret;
    // }
    // public void dfs(TreeNode root, List<Integer> ret) {
    //      if(root!=null){
    //         dfs(root.left,ret);
    //         dfs(root.right,ret);
    //         ret.add(root.val);
    //     }
    // }
    
//     ITERATIVE SOLUTION using 2 stacks
//      public List<Integer> postorderTraversal(TreeNode root) {
//         ArrayList < Integer > postOrder = new ArrayList < > ();
//         if (root == null){
//           return postOrder;  
//         } 

//         Stack < TreeNode > s1 = new Stack < > ();
//         Stack < TreeNode > s2 = new Stack < > ();
//         s1.push(root);
//          while(!s1.isEmpty()){
//              TreeNode top=s1.peek();
//              s1.pop();
//              s2.push(top);
//              if(top.left!=null){
//                  s1.push(top.left);
//              }
//             if(top.right!=null){
//                  s1.push(top.right);
//              }
//          }
//           while (!s2.isEmpty()) {
//             postOrder.add(s2.peek().val);
//             s2.pop();
//           }
//          return postOrder;
//      }
    
    //     ITERATIVE SOLUTION using 1 stack
     public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList < Integer > postOrder = new ArrayList < > ();
        if (root == null){
          return postOrder;  
        } 

        Stack < TreeNode > st = new Stack < > ();
         while(root !=null || !st.isEmpty()){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    postOrder.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.val);
                    }
                }else{
                    root=temp;
                }
            }  
         }
         return postOrder;
     }
}