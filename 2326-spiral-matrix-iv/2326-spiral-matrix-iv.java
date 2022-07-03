/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) 
    {
        int[][] matrix = new int[m][n];
        
        //Initialize the matrix with -1
        //After linked list is completed, rest matrix cells will be -1
        for(int[] row : matrix)
            Arrays.fill(row , -1);
        
        //Base/Edge case
        if(head == null)
            return matrix;
        
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        ListNode current = head;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                //If we have linked list node values, then only fill it in matrix cell else do nothing
                if(current != null){                            
                    matrix[rowBegin][j] = current.val;
                    current = current.next;
                }
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                if(current != null){
                    matrix[j][colEnd] = current.val;
                    current = current.next;
                }
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    if(current != null){
                        matrix[rowEnd][j] = current.val;
                        current = current.next;
                    }
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    if(current != null){
                        matrix[j][colBegin] = current.val;
                        current = current.next;
                    }
                }
            }
            colBegin ++;
        }
        return matrix;
    }
}