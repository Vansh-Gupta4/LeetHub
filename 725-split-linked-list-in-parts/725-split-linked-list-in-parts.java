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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        int part=count/k;
        int rem=count%k;
        
        ListNode node = head, prev = null;
        int i=0;
        while(i<k && node!=null){
            ans[i]=node;
            for(int j=0;j<part+(rem>0?1:0);j++){
                prev=node;
                node=node.next;
            }
            prev.next=null;
            i++;
            rem--;
        }
        return ans;
    }
}