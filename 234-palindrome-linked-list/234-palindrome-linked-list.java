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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, tmp;
	    while(fast!=null && fast.next!=null){ // finding mid point
		    fast = fast.next.next;
		    tmp = slow.next; slow.next = prev; prev = slow; slow = tmp;        
        }
	    slow = (fast!=null ? slow.next : slow); // for odd length case as mentioned above
	    while(slow!=null){ // check if linked lists starting at prev and slow are equal
		    if(slow.val != prev.val) return false;
		    else{
              slow = slow.next;
              prev = prev.next;  
            } 
        }
	 return true;
    }
}