/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        while(head1!=null){
            ListNode temp=head2;
            while(temp!=null){
                if(head1==temp){
                    return head1;
                }
                temp=temp.next;
            }
            head1=head1.next;
        }
        return null;
    }
}