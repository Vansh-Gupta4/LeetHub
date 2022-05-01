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
class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
} 
//     Using Inorder Traversal
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
//         Queue < Tuple > q = new LinkedList < Tuple > ();
//         q.offer(new Tuple(root, 0, 0));
//         while (!q.isEmpty()) {   //for entire level order traversal
//             Tuple tuple = q.poll();
//             TreeNode node = tuple.node;
//             int x = tuple.row;
//             int y = tuple.col;


//             if (!map.containsKey(x)) { //if for vertical ...treeMap doesn't exist...then make it
//                 map.put(x, new TreeMap < > ());
//             }
//             if (!map.get(x).containsKey(y)) {//if for level ...PriorityQueue doesn't exist...then make it
//                 map.get(x).put(y, new PriorityQueue < > ());
//             }
//             map.get(x).get(y).offer(node.val); //PriorityQ mai insert kardi val

//             if (node.left != null) {  //left exist karta h toh left jaaoo
//                 q.offer(new Tuple(node.left, x - 1, y + 1));
//             }
//             if (node.right != null) { //right exist karta h toh right jaaoo
//                 q.offer(new Tuple(node.right, x + 1, y + 1));
//             }
//         }
//         List < List < Integer >> list = new ArrayList < > ();
//         for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) { //sab vertical par iterate
//             list.add(new ArrayList < > ());   //empty list banai sab vertical ke liye
//             for (PriorityQueue < Integer > nodes: ys.values()) {
//                 while (!nodes.isEmpty()) {
//                     list.get(list.size() - 1).add(nodes.poll());
//                 }
//             }
//         }
//         return list;
//     }
//}    
    
//     USING PREORDER TRAVERSAL
     public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        solve(root, map, 0, 0);


        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> v: map.values()) {
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : v.values()) {
                while(!pq.isEmpty()) temp.add(pq.remove());
            }
            res.add(temp);
        }


        return res;
    }
    
    private void solve(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int v, int l) {
        if(root == null) return;
        
        map.putIfAbsent(v, new TreeMap<>());
        map.get(v).putIfAbsent(l, new PriorityQueue<Integer>());
        
        map.get(v).get(l).add(root.val);
        
        solve(root.left, map, v - 1, l + 1);
        solve(root.right, map, v + 1, l + 1);
    }
}